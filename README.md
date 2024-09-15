---

# Shopping List API

Welcome to the **Shopping List API**! This is a RESTful API designed to manage a shopping list with seamless integration to a MySQL database. It includes a simple front-end for adding products, making it ideal for demonstration purposes in local development environments.

## Features

- **RESTful API**: CRUD operations for managing shopping list items.
- **MySQL Integration**: Data is stored securely using a MySQL database.
- **Priority System**: Assign product priorities (e.g., "high", "medium", "low") which are stored as byte values.
- **Local Hosting**: The API and website are intended to be run on local development servers, such as those provided by IDEs (e.g., IntelliJ, Eclipse).

## Tech Stack

- **Backend**: Spring Boot (Java), RESTful API
- **Database**: MySQL
- **Frontend**: Basic HTML, CSS, and JavaScript for interacting with the API
- **Development Tools**: Local server (IDE-based)

## Installation

To run this project locally, follow these steps:

### Prerequisites

- [JDK 22](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [MySQL](https://dev.mysql.com/downloads/)
- [Maven](https://maven.apache.org/download.cgi)

### Steps

1. Clone the repository:

    ```bash
    git clone https://github.com/K0kai/shopping-list-api.git
    ```

2. Navigate to the project directory:

    ```bash
    cd shopping-list-api
    ```

3. Set up the MySQL database:

    - Create a new database called `lista_compras`.
    - Update the `application.properties` file with your MySQL username, password, and database URL.

    Example configuration in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/lista_compras
    spring.datasource.username=yourUsername
    spring.datasource.password=yourPassword
    ```

4. Build and run the project:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

5. Access the API via `http://localhost:8080/itens` and the frontend you can access by using a live server or an IDE to run the html file and adding your port to the access origins in the controller and the `WebConfig`.

## Usage

Once the project is running:

- You can add, update, view, and delete products in your shopping list using the provided API endpoints.
- Use the simple front-end interface to interact with the API for adding products.

### Example API Requests

- **Add a product**:  
    `POST /itens`
    ```json
    {
      "name": "Milk",
      "quantity": 2,
      "priority": "high"
    }
    ```

- **Get all products**:  
    `GET /itens`

- **Update a product**:  
    `PUT /itens/{id}`

- **Delete a product**:  
    `DELETE /itens/{id}`
	`DELETE /itens/all`

## Project Structure

```
shopping-list-api/
│
├── src/
│   ├── main/
│   │   ├── java/com/kokai/
│   │   │   ├── config/       // Configuration Classes
│   │   │   ├── controller/   // REST Controllers
│   │   │   ├── converter/    // Converters for Data Types
│   │   │   ├── entity/       // Entity Classes
│   │   │   ├── lista_compras/ // Core Shopping List Logic
│   │   │   ├── repository/   // Repositories
│   │   │   └── service/      // Business Logic
│   │   └── resources/│   │ 
│   │       └── application.properties  // DB Config
│   └── test/                 // Unit and Integration Tests
│
├── pom.xml                 // Maven Dependencies
├── site.html               // Frontend
└── README.md               // This file
```

## Future Improvements

- Add authentication and authorization (e.g., JWT).
- Add integration with WhatsApp bots.
- Enhance the API paths by adding more layers.
- Renaming the portuguese files and methods to conventional english.

## Video Demos

https://github.com/user-attachments/assets/3ecae15b-ecf5-4c40-b665-f9a4d94b14c3

https://github.com/user-attachments/assets/27befd14-c4ae-4f52-bfd7-d0e3b3287b4a

## Contact

For any questions or inquiries, feel free to contact me at: [lipalupa1@gmail.com].

---
