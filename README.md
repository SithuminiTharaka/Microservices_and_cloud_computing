# Multi-Module Spring Boot Project - Microservices_n_Cloud_Computing_Assignment

This repository contains a multi-module Spring Boot project with two services: `department` and `employee`. Each service is designed to interact with a MySQL database, providing REST APIs to manage department and employee data.

## Screenshots

#### **1. Create Department**
<p align="center">
  <img width="80%"  src="/ScreenShoots/01. Create Department.png" alt="01. Create Department">
</p>

#### **02. Select Department**
<p align="center">
  <img width="80%"  src="/ScreenShoots/02. Select Department.png" alt="02. Select Department">
</p>

#### **03. Select All Departments**
<p align="center">
  <img width="80%"  src="/ScreenShoots/03. Select All Departments.png" alt="03. Select All Departments">
</p>

#### **04. Create Employee**
<p align="center">
  <img width="80%"  src="/ScreenShoots/04. Create Employee.png" alt="04. Create Employee">
</p>

#### **05. Select Employee**
<p align="center">
  <img width="80%"  src="/ScreenShoots/05. Select Employee.png" alt="05. Select Employee">
</p>

#### **06. Select All Employees**
<p align="center">
  <img width="80%"  src="/ScreenShoots/06. Select All Employees.png" alt="06. Select All Employees">
</p>

<br>

## Technologies Used
- **Java**: Programming language (JDK 17 or higher recommended).
- **Spring Boot**: Framework for building RESTful services and managing dependencies.
- **Spring Web**: For creating REST APIs.
- **Spring Data JPA**: For database operations and entity management.
- **MySQL**: Relational database for storing department and employee data.
- **Maven**: Dependency management and build tool.
- **IntelliJ IDEA**: IDE used for development.
- **Postman**: Test APIs.

## Dependencies
The following dependencies are used in both the `department` and `employee` modules (defined in their respective `pom.xml` files):

- **Spring Web** (`spring-boot-starter-web`): Provides tools to build RESTful APIs.
- **Spring Data JPA** (`spring-boot-starter-data-jpa`): Simplifies database interactions with JPA and Hibernate.
- **MySQL Driver** (`mysql-connector-j`): Enables connectivity to the MySQL database.

### Example `pom.xml` Dependencies
```xml
<dependencies>
    <!-- Spring Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <!-- MySQL Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

## Project Structure
- **`multi-module-springboot`**: Parent Maven project.
  - **`department`**: Module for managing department data (runs on port `8081`).
  - **`employee`**: Module for managing employee data (runs on port `8082`).

## Error Faced and Resolution
During development, I encountered the following error when running the `department` service:

```
Table 'department_db.department' doesn't exist
```

### Cause
This error occurred because the database table (`department`) was not created automatically when the application started.

### Fix
I resolved this by updating the `application.properties` file in the `department` module (and similarly for the `employee` module). I added the following property:

```properties
spring.jpa.hibernate.ddl-auto=update
```

#### Explanation
- **`spring.jpa.hibernate.ddl-auto=update`**: Automatically creates or updates the database tables based on the JPA entities defined in the code (e.g., `Department` and `Employee` classes). This ensures that the schema is generated or modified when the application starts, avoiding the "table doesn't exist" error.

After applying this fix, the application successfully created the `department` table in the `department_db` database (and the `employee` table in the `employee_db` database) and ran without issues.

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   ```
2. **Set Up MySQL**:
   - Create two databases: `department_db` and `employee_db`.
   - Update `application.properties` in each module with your MySQL credentials.
3. **Run the Project**:
   - Open the project in IntelliJ IDEA.
   - Run `DepartmentApplication` (port `8081`) and `EmployeeApplication` (port `8082`).
4. **Test APIs**:
   - Use Postman or `curl` to test the REST endpoints (e.g., `POST /departments`, `GET /departments/{id}`).
