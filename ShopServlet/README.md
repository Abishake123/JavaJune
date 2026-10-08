# ShopServlet — Plain Servlet + JDBC CRUD

A minimal Java web app that does **Create / Read / Update / Delete** on a MySQL table
using only **Servlets + JDBC**. No Maven, no Gradle, no Spring — just `javac` and Tomcat.

- Database: `shop`
- Table: `products`
- Endpoint: `/products` (JSON)
- Bonus: a tiny HTML page (`index.html`) to click through the CRUD in the browser

---

## 1. Project structure

```
ShopServlet/
├── README.md                  <- you are here
├── build.sh                   <- compiles with javac + deploys to Tomcat
├── sql/
│   └── schema.sql             <- creates the shop DB + products table
├── src/com/shop/
│   ├── db/DBConnection.java   <- JDBC URL, user, password  (EDIT THIS)
│   ├── model/Product.java     <- plain Java object for one row
│   ├── dao/ProductDAO.java    <- all SQL (PreparedStatements)
│   └── servlet/ProductServlet.java  <- HTTP GET/POST/PUT/DELETE handlers
└── webapp/                    <- this folder IS the web app Tomcat runs
    ├── index.html             <- simple UI
    └── WEB-INF/
        ├── web.xml            <- maps /products -> ProductServlet
        ├── lib/mysql-connector-j-26.7.0.jar   <- MySQL JDBC driver
        └── classes/           <- compiled .class files go here (created by build.sh)
```

### How a request flows

```
Browser / curl
   │  HTTP  (GET/POST/PUT/DELETE /shop/products)
   ▼
Tomcat ──reads web.xml──► ProductServlet   (parses params, returns JSON)
                              │
                              ▼
                          ProductDAO       (SQL with PreparedStatement)
                              │
                              ▼
                          DBConnection ──JDBC──► MySQL  shop.products
```

---

## 2. Requirements

| Thing        | Version used          | Check with          |
|--------------|-----------------------|---------------------|
| JDK          | 17 (11+ works)        | `java -version`     |
| MySQL        | 8 / 9                 | `mysql --version`   |
| Apache Tomcat| **10.1.x** (or 11)    | —                   |
| MySQL driver | already in `webapp/WEB-INF/lib` | —         |

> **Important:** This project uses `jakarta.servlet.*`, so it needs **Tomcat 10 or newer**.
> Tomcat 9 and older use `javax.servlet.*` and will NOT load it.

---

## 3. Setup (one time)

### Step 1 — Create the database

```bash
mysql -u root -p < sql/schema.sql
```

This creates the `shop` database, the `products` table, and 3 sample rows.

Table definition:

| Column       | Type           | Notes                    |
|--------------|----------------|--------------------------|
| `product_id` | INT            | Primary key, auto-increment |
| `name`       | VARCHAR(100)   | required                 |
| `price`      | DECIMAL(10,2)  | required                 |
| `quantity`   | INT            | default 0                |

> If you already have a `shop.products` table with these columns, you can skip this step.
> Running it again only adds the 3 sample rows again. It won't recreate the table.

### Step 2 — Set your DB username/password

Open `src/com/shop/db/DBConnection.java` and edit:

```java
private static final String URL = "jdbc:mysql://localhost:3306/shop";
private static final String USER = "root";
private static final String PASSWORD = "password";
```

### Step 3 — Install Tomcat (no build tool, just unzip)

**Option A: download manually (works everywhere)**
1. Go to https://tomcat.apache.org/download-10.cgi
2. Under *Binary Distributions → Core*, download the **zip / tar.gz**
3. Unzip it anywhere, e.g. `~/apache-tomcat-10.1.xx`
4. Make the scripts executable (macOS/Linux):
   ```bash
   chmod +x ~/apache-tomcat-10.1.xx/bin/*.sh
   ```

**Option B: Homebrew on macOS**
```bash
brew install tomcat@10
```
Tomcat home will then be `$(brew --prefix tomcat@10)/libexec`.

### Step 4 — Tell your shell where Tomcat is

```bash
export CATALINA_HOME=~/apache-tomcat-10.1.xx
```

For Homebrew, use this instead:

```bash
export CATALINA_HOME=$(brew --prefix tomcat@10)/libexec
```

(Add that line to `~/.zshrc` so you don't need to repeat it.)

---

## 4. Build & Run

From the `ShopServlet` folder:

```bash
./build.sh deploy
```

That does two things:
1. `javac` compiles everything in `src/` into `webapp/WEB-INF/classes`, using Tomcat's `lib/servlet-api.jar` on the classpath.
2. It copies `webapp/` to `$CATALINA_HOME/webapps/shop`.

Start Tomcat:

```bash
$CATALINA_HOME/bin/startup.sh
```

Open **http://localhost:8080/shop/** in the browser.

Stop Tomcat:

```bash
$CATALINA_HOME/bin/shutdown.sh
```

**After changing code:** run `./build.sh deploy` again. Tomcat will usually auto-reload
the app within a few seconds. If it doesn't, restart Tomcat.

### What build.sh does, if you'd rather type it yourself

```bash
mkdir -p webapp/WEB-INF/classes
javac -cp "$CATALINA_HOME/lib/servlet-api.jar:webapp/WEB-INF/lib/*" \
      -d webapp/WEB-INF/classes $(find src -name "*.java")
rm -rf $CATALINA_HOME/webapps/shop
cp -R webapp $CATALINA_HOME/webapps/shop
```

(Windows: use `;` instead of `:` in the classpath and `%CATALINA_HOME%\bin\startup.bat`.)

---

## 5. How to use it

### A) In the browser
Go to **http://localhost:8080/shop/**
- Fill Name / Price / Qty, leave ID blank, then click **Save** to create a product
- Click **Edit** on a row, change the values, then click **Save** to update it
- Click **Delete** to remove a product

### B) API endpoints

Base URL: `http://localhost:8080/shop/products`

| Action     | Method | URL                  | Body (form fields)          | Success |
|------------|--------|----------------------|-----------------------------|---------|
| List all   | GET    | `/products`          | —                           | 200     |
| Get one    | GET    | `/products?id=1`     | —                           | 200 / 404 |
| Create     | POST   | `/products`          | `name`, `price`, `quantity` | 201     |
| Update     | PUT    | `/products?id=1`     | `name`, `price`, `quantity` | 200 / 404 |
| Delete     | DELETE | `/products?id=1`     | —                           | 200 / 404 |

Bad input returns **400**, and DB problems return **500**. Error responses look like `{"error":"..."}`.

### C) curl examples

List all:

```bash
curl http://localhost:8080/shop/products
```

Get one:

```bash
curl "http://localhost:8080/shop/products?id=1"
```

Create:

```bash
curl -X POST -d "name=Pen&price=10.50&quantity=100" http://localhost:8080/shop/products
```

Update:

```bash
curl -X PUT -d "name=Blue Pen&price=12&quantity=80" "http://localhost:8080/shop/products?id=1"
```

Delete:

```bash
curl -X DELETE "http://localhost:8080/shop/products?id=1"
```

Sample response:
```json
[{"id":1,"name":"Keyboard","price":1499.00,"quantity":10}]
```

(In Postman: for POST/PUT pick **Body → x-www-form-urlencoded**.)

---

## 6. Troubleshooting

| Problem | Fix |
|---------|-----|
| `CATALINA_HOME is not set` | Run the `export CATALINA_HOME=...` from Step 4 |
| `package jakarta.servlet does not exist` | `CATALINA_HOME` is wrong, or it's Tomcat 9. Use Tomcat 10+ |
| 404 at `/shop/` | Tomcat not started, or not deployed. Check that `$CATALINA_HOME/webapps/shop` exists |
| 500 `Access denied for user` | Wrong USER/PASSWORD in `DBConnection.java` |
| 500 `Unknown database 'shop'` | Run `sql/schema.sql` (Step 1) |
| 500 `Communications link failure` | MySQL isn't running. Start it: `brew services start mysql` |
| `Address already in use` / port 8080 busy | Another process is using 8080. Stop it, or change the port in `$CATALINA_HOME/conf/server.xml` |
| Anything else | Read the log: `tail -f $CATALINA_HOME/logs/catalina.out` |

---

## 7. Key concepts in this project

- **Servlet**: a Java class that extends `HttpServlet` and overrides `doGet`, `doPost`, `doPut`, and `doDelete`. Tomcat calls the right method for each HTTP request.
- **web.xml**: the deployment descriptor. It tells Tomcat that `/products` is handled by `ProductServlet`.
- **DAO pattern**: all SQL is in `ProductDAO`, so the servlet only deals with HTTP.
- **PreparedStatement**: uses `?` placeholders, which prevents SQL injection.
- **try-with-resources**: closes the `Connection`, `Statement`, and `ResultSet` automatically.
- **WEB-INF/lib**: any jar placed here (such as the MySQL driver) is on the app's classpath at runtime.
- **PUT body parsing**: servlets only auto-parse form data for POST, so `ProductServlet.parseFormBody()` reads the PUT body by hand.
