# 🏥 Hospital Management System – REST API

A Spring Boot-based Hospital Management System that provides RESTful APIs to manage Patients, Doctors, Appointments, and Billing records. It performs CRUD operations and handles relational data with ease using Spring Data JPA and MySQL.

---

## 🚀 Features

- 👨‍⚕️ **Doctors** – Add, update, view, and delete doctor records.
- 🧑‍🤝‍🧑 **Patients** – Register, update, and manage patient details.
- 📅 **Appointments** – Schedule and retrieve appointments between doctors and patients.
- 💵 **Billing** – Generate and track patient billing information.

---

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot 3.5.x**
- **Spring Data JPA**
- **Spring Web**
- **MySQL 8.x** (via XAMPP/phpMyAdmin)
- **Maven** for build and dependency management
- **Lombok** *(optional)* for reducing boilerplate
- **Postman** for API testing

---

## 📦 Dependencies

Add the following dependencies to your `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot Web Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Boot DevTools (for hot reload) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok (optional) -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>

    <!-- Spring Boot Test (for unit testing) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

⚙️ Application Properties
Configure the following in src/main/resources/application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

# 🔗 Sample API Endpoints
Patients
- GET /api/patients – List all patients

- POST /api/patients – Create a new patient

- GET /api/patients/{id} – Get patient by ID

- PUT /api/patients/{id} – Update existing patient

- DELETE /api/patients/{id} – Delete a patient

Doctors
- GET /api/doctors

- POST /api/doctors

- GET /api/doctors/{id} – Get Doctor by ID

- PUT /api/patients/{id} – Update existing Doctor

- DELETE /api/patients/{id} – Delete a Doctor

...

Appointments
- GET /api/appointments

- POST /api/appointments

##Billing
- GET /api/bills

- POST /api/bills
