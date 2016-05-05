# Spring-Swagger API Boilerplate

## Overview
This project provides a boilerplate for demonstrating the basics of enabling Swagger 2.0 definitions on a Spring Boot project with RESTful endpoints. The project is based on a CRUD application for managing `Person` objects with REST endpoints exposed for all the operations that can be performed on the entity being managed. The project is a Spring Boot application that is annotated to enable support for Swagger 2.0. A `Docket` is defined on the `Application` class to initialize the underlying services that are responsible for generating the Swagger definitions. Springfox automatically detects the use of Spring Boot Web MVC and infers from the endpoints defined in the `PersonController` and generates the corresponding API definitions for Swagger. New Swagger-specific endpoints are injected into the Spring Boot application to allow for browsing the documentation using Swagger UI as well as for viewing the resulting JSON Swagger Definitions file. 

## Technologies
The following are the key technologies used in the project:
- Spring Boot [http://projects.spring.io/spring-boot/](http://projects.spring.io/spring-boot/)
- Springfox [http://springfox.github.io/springfox/docs/current/](http://springfox.github.io/springfox/docs/current/)
- Spring Data JPA
- H2 Database

## Running the Project
To run the project:

1. Clone this repository
2. Go to the root directory of the repository: `cd ./spring-swagger-api`  
3. Run the `package` Maven task: `mvn package`
4. Go to the `target` directory
5. Run the generated JAR file: `java -jar <JAR-file>`

> *Note:* that there is no UI for this application; it only exposes REST endpoints

To view the generated Swagger UI documentation go to: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

To view the JSON Swagger definitions, go to: [http://localhost:8080/v2/api-docs?group=spring-swagger-api](http://localhost:8080/v2/api-docs?group=spring-swagger-api)
Where the group name is specified in the `Docket` specification in [Application.java](https://github.com/afajem/spring-swagger-api/blob/master/src/main/java/com/niran/reference/api/Application.java)
