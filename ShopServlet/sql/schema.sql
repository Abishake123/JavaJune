-- Run this once:  mysql -u root -p < sql/schema.sql

CREATE DATABASE IF NOT EXISTS shop;
USE shop;

CREATE TABLE IF NOT EXISTS products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100)   NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    quantity   INT            NOT NULL DEFAULT 0
);

-- A few sample rows so GET has something to show.
-- (Skip these if your table already has data - running the file twice adds them twice.)
INSERT INTO products (name, price, quantity) VALUES
    ('Keyboard', 1499.00, 10),
    ('Mouse',     599.50, 25),
    ('Monitor', 12999.99,  5);
