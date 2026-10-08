package com.shop.servlet;

import com.shop.dao.ProductDAO;
import com.shop.model.Product;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CRUD endpoints for products. Mapped to /products in web.xml.
 *
 *   GET    /products          -> list all
 *   GET    /products?id=1     -> get one
 *   POST   /products          -> create   (form fields: name, price, quantity)
 *   PUT    /products?id=1     -> update   (form fields: name, price, quantity)
 *   DELETE /products?id=1     -> delete
 *
 * All responses are JSON.
 */
public class ProductServlet extends HttpServlet {

    private final ProductDAO dao = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String id = req.getParameter("id");
            if (id == null) {
                List<Product> products = dao.findAll();
                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < products.size(); i++) {
                    if (i > 0) json.append(",");
                    json.append(products.get(i).toJson());
                }
                json.append("]");
                send(resp, 200, json.toString());
            } else {
                Product p = dao.findById(Integer.parseInt(id));
                if (p == null) {
                    sendError(resp, 404, "Product " + id + " not found");
                } else {
                    send(resp, 200, p.toJson());
                }
            }
        } catch (NumberFormatException e) {
            sendError(resp, 400, "id must be a number");
        } catch (SQLException e) {
            sendError(resp, 500, "Database error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("name", req.getParameter("name"));
        params.put("price", req.getParameter("price"));
        params.put("quantity", req.getParameter("quantity"));
        try {
            Product p = buildProduct(params);
            dao.create(p);
            send(resp, 201, p.toJson());
        } catch (IllegalArgumentException e) {
            sendError(resp, 400, e.getMessage());
        } catch (SQLException e) {
            sendError(resp, 500, "Database error: " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Servlets only auto-parse form bodies for POST, so read the PUT body ourselves.
        Map<String, String> params = parseFormBody(req);
        String id = req.getParameter("id") != null ? req.getParameter("id") : params.get("id");
        try {
            if (id == null) {
                throw new IllegalArgumentException("id is required");
            }
            Product p = buildProduct(params);
            p.setId(Integer.parseInt(id));
            if (dao.update(p)) {
                send(resp, 200, p.toJson());
            } else {
                sendError(resp, 404, "Product " + id + " not found");
            }
        } catch (IllegalArgumentException e) {
            sendError(resp, 400, e.getMessage());
        } catch (SQLException e) {
            sendError(resp, 500, "Database error: " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        try {
            if (id == null) {
                throw new IllegalArgumentException("id is required");
            }
            if (dao.delete(Integer.parseInt(id))) {
                send(resp, 200, "{\"message\":\"Product " + id + " deleted\"}");
            } else {
                sendError(resp, 404, "Product " + id + " not found");
            }
        } catch (IllegalArgumentException e) {
            sendError(resp, 400, e.getMessage());
        } catch (SQLException e) {
            sendError(resp, 500, "Database error: " + e.getMessage());
        }
    }

    // ---------- helpers ----------

    /** Validates the fields and builds a Product. Throws IllegalArgumentException on bad input. */
    private Product buildProduct(Map<String, String> params) {
        String name = params.get("name");
        String price = params.get("price");
        String quantity = params.get("quantity");
        if (name == null || name.isBlank() || price == null || quantity == null) {
            throw new IllegalArgumentException("name, price and quantity are required");
        }
        Product p = new Product();
        p.setName(name.trim());
        try {
            p.setPrice(new BigDecimal(price));
            p.setQuantity(Integer.parseInt(quantity));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("price and quantity must be numbers");
        }
        return p;
    }

    /** Parses an application/x-www-form-urlencoded body like "name=Pen&price=10&quantity=3". */
    private Map<String, String> parseFormBody(HttpServletRequest req) throws IOException {
        Map<String, String> params = new HashMap<>();
        StringBuilder body = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                body.append(line);
            }
        }
        for (String pair : body.toString().split("&")) {
            if (pair.isEmpty()) continue;
            String[] kv = pair.split("=", 2);
            String key = URLDecoder.decode(kv[0], StandardCharsets.UTF_8);
            String value = kv.length > 1 ? URLDecoder.decode(kv[1], StandardCharsets.UTF_8) : "";
            params.put(key, value);
        }
        return params;
    }

    private void send(HttpServletResponse resp, int status, String json) throws IOException {
        resp.setStatus(status);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    private void sendError(HttpServletResponse resp, int status, String message) throws IOException {
        send(resp, status, "{\"error\":\"" + message.replace("\"", "'") + "\"}");
    }
}
