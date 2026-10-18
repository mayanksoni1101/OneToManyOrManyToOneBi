# Merchant & Product Management System (JPA / Hibernate One-to-Many / Many-to-One Bi-directional)

A comprehensive Java application demonstrating **One-to-Many / Many-to-One Bi-directional** mapping between `Merchant` and `Product` entities using **JPA (Java Persistence API)** and **Hibernate ORM** under the `org.jsp.onetomanyormanytoonebi` package.

---

## 📌 Project Overview

This project models a relational domain where:
* **`Merchant` (Parent / One-to-Many):** A merchant can own multiple products (`@OneToMany(cascade = CascadeType.ALL, mappedBy = "m")`).
* **`Product` (Child / Many-to-One):** Every product belongs to a specific merchant (`@ManyToOne` with `@JoinColumn`).

The repository includes entity classes, data insertion scripts, and a full suite of query utility classes to perform lookup operations on both entities using JPA `EntityManager` and JPQL/HQL queries.

---

## 📂 Project Architecture & Component Breakdown

### 1. Entity Classes
* **`Merchant.java`**: Maps the `Merchant` entity with auto-generated primary key (`id`), unique credentials (`gst_num`, `phone`, `email`), `name`, `password`, and a list of linked products (`prods`).
* **`Product.java`**: Maps the `Product` entity with `id`, `name`, `brand`, `category`, `price`, and a `@ManyToOne` reference (`m`) pointing back to its parent `Merchant`.

### 2. Data Insertion Utility
* **`InsertData.java`**: Demonstrates cascade persistence by creating a `Merchant` and associating multiple `Product` records (`Laptop`, `Mouse`, `Keyboard`, `Monitor`) before calling `em.persist(merchant)`.

### 3. Query & Utility Classes

#### 🟢 Merchant Lookup Operations
* **`FindMerchantById.java`**: Fetches a merchant by primary key using `em.find()`.
* **`FindMerchantByName.java`**: Lists merchants matching a given name string.
* **`FindMechantByGstNum.java`**: Fetches a unique merchant by GST number.
* **`FindMerchantByIdAndPassword.java`**: Authenticates and retrieves a merchant using ID and password.
* **`FindMerchantByPhoneAndPassword.java`**: Authenticates and retrieves a merchant using phone number and password.
* **`FindMerchantByProductId.java`**: Traverses the relationship in reverse via JPQL (`select p.m from Product p where p.id = ?1`) to find the merchant associated with a given product ID.

#### 🔵 Product Lookup Operations
* **`FindProductBiId.java`**: Fetches a product by its primary key (`id`) using `em.find()`.
* **`FindProductByName.java`**: Retrieves all products matching a specific product name.
* **`FindProductByBrand.java`**: Filters products by brand name (e.g., Lenovo).
* **`FindProductByCategory.java`**: Filters products by category (e.g., Electronics).
* **`FindProdcutsBetweenPriceRange.java`**: Queries products within a specified minimum and maximum price range.
* **`FindProductsByMerchantId.java`**: Finds all products owned by a specific merchant ID (`p.m.id = ?1`).
* **`FindProductsByMerchantGst_Num.java`**: Queries products linked to a merchant's GST number (`p.m.gst_num = ?1`).
* **`FindProductsByMerchantIdAndPassword.java`**: Authenticates merchant ID/password to retrieve their registered products.
* **`FindProductsByMerchantPhoneAndPassword.java`**: Authenticates merchant phone/password to retrieve their registered products.

---

## 🛠️ Tech Stack & Key Annotations

* **Language:** Java
* **ORM / Persistence:** JPA 2.0+ / Hibernate
* **Mapping Annotations:** `@Entity`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`, `@Column(unique = true)`, `@OneToMany`, `@ManyToOne`, `@JoinColumn`
* **Query API:** `EntityManager`, `TypedQuery`, `Query` (JPQL)

---

## ⚙️ Setup & Execution Instructions

1. **Database Configuration:**
   Verify that your database configuration is specified in `src/META-INF/persistence.xml` under the persistence unit name `"M15"`.

2. **Populate Data:**
   Run `InsertData.java` to seed initial merchant and product records into the database.

3. **Execute Queries:**
   Run any of the `Find*.java` classes as Java applications to interact with and query the database via the console prompts.
