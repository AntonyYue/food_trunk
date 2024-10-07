# Food Truck Management System

This project is a Spring Boot-based application that provides a REST API to  query food trucks using an in-memory H2 database. The data is imported from a CSV file, and the system provides paginated results for easy querying. The project utilizes several key technologies, including Spring Data JPA, OpenCSV, and Swagger for API documentation.

## Features

- Import food truck data from a CSV file automatically.
- Store the data in an in-memory H2 database.
- Provide a REST API to query food truck information.
- API documentation with Swagger UI.
- Unit testing with JUnit 5 and Mockito.

## Technologies Used

- Java 17
- Spring Boot 3.3.4
- Spring Data JPA
- OpenCSV
- Swagger UI
- H2 in-memory database
- MapStruct
- Lombok
- JUnit 5 and Mockito

## Getting Started

### Prerequisites

- Java 17
- Maven 3.x

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/food_truck.git

2. Navigate to the project directory:
   ```bash
   cd food_truck
3. mvn clean install
    ```bash
   mvn clean install
4. mvn spring-boot:run
   ```bash
   mvn spring-boot:run
### Accessing the API
Swagger UI documentation is available at:
[Swagger](http://localhost:8080/swagger-ui/index.html)

This is the only API currently provided,you can import into postman or call this directly:
  ````bash
curl -X 'GET' \
  'http://localhost:8080/api/foodtrucks?foodItem=Noodles&pageNumber=0&pageSize=10' \
  -H 'accept: */*'


