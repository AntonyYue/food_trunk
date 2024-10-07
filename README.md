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
   git clone https://github.com/AntonyYue/food_trunk.git

2. Navigate to the project directory:
   ```bash
   cd food_truck
3. mvn clean install
    ```bash
   mvn clean install
4. mvn spring-boot:run
   ```bash
   mvn spring-boot:run

**Note**: If you are in China, you may need to configure proxy settings and mirrors, as GitHub and Maven repositories may not be accessible. You can refer to the following configuration:

- Configure Maven mirrors in `~/.m2/settings.xml`.
- Use proxy settings to ensure access to external resources.

### Accessing the API
Swagger UI documentation is available at:
[Swagger](http://localhost:8080/swagger-ui/index.html)

This is the only API currently provided,you can import into postman or call this directly:

  ```bash
   curl -X 'GET' \
  'http://localhost:8080/api/foodtrucks?foodItem=Noodles&pageNumber=0&pageSize=10' \
  -H 'accept: */*'
  ```

## Project Structure
```
src
├── main
│   ├── java
│   │   └── org.example.food_truck
│   │       ├── controller
│   │       ├── config
│   │       ├── impl
│   │       ├── csv
│   │       ├── dto
│   │       ├── entity
│   │       ├── mapper
│   │       ├── repository
│   │       ├── service
│   │       ├── vo
│   │       └── util
│   └── resources
│       ├── application.properties
│       └── Mobile_Food_Facility_Permit.csv.csv
└── test
    └── java
        └── com.example.foodtruck
            ├── controller
            └── service
```


### Future Plans

1. **Data Import Support**: Enhance data import functionality with validation and error reporting.
2. **Full-text Search**: Implement full-text search using Elasticsearch, along with NLP for tokenization.
3. **Proximity Search**: Use Geohash for proximity searches, considering that the same location may have different latitude and longitude values from various service providers due to the use of different coordinate systems, which presents some challenges.
4. **Popular Search Term Statistics**: Track and analyze popular search terms.
5. **City/Region ID Generation**: Generate unique IDs for cities or regions for future sharding.
6. **Cursor-based Pagination**: Implement cursor-based pagination instead of traditional pagination for more efficient data retrieval.

## Performance Optimization

1. **Short-term Caching**: Use short-term caching for popular search results to improve query efficiency.
2. **Sharding by Region ID**: Implement sharding based on city or region IDs using Kubernetes for better concurrency and horizontal scaling.
3. **Cursor-based Pagination**: Implement cursor-based pagination instead of traditional pagination for more efficient data retrieval.


## License

This project is licensed under the MIT License. See the [LICENSE](https://github.com/AntonyYue/food_trunk?tab=MIT-1-ov-file) file for more information.
