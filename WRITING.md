# STEPS
## Project Starter
- check Java version by running `java -version`
- check if `java -version` returns `17.*`
- use spring initializr to create a new Spring Boot project
- add dependencies to such as Spring Boot DevTools, Lombok, Spring Web, Rest Repositories, Spring Security, Spring Data JPA, H2 Database, PostgreSQL Driver 

## Entity
- add javax.validation
- add spring-boot-starter-validation
- create an antiHero package inside the com.example.superheroes folder
- create an entity package inside the antiHero package
- write an AntiHeroEntity class inside the entity package

## Dto
- create a dto package inside the antiHero package
- write an AntiHeroDto class inside the dto package

## Contract (interface)
- create a contract package inside the antiHero package
- write an AntiHeroContract interface inside the contract package

## Repository
- create a repository package inside the antiHero package
- write an AntiHeroRepository interface inside the repository package

## Exception
- create an exception package inside the com.example.superheroes folder
- write a NotFoundException class inside the exception package

## Service
- create a service package inside the antiHero package
- write an AntiHeroService interface inside the service package

## Dto Packages (one-time setup)
- add modelmapper and mapstruct in the pom.xml

## Logging Package (one-time setup)
- add spring-boot-starter-log4j2 in the pom.xml
- add log4j2-spring.xml in the main/resources folder

## Application Properties
- update application.properties by adding h2 inmemory database for proof of concept

## Configurations (no-user and no-auth yet)
- add spring-boot-configuration-processor in the pom.xml
- create a config package inside the com.example.superheroes folder
- add a ModelMapperConfig class inside the config package
- add CorsConfig class inside the config package, don't put anything related to security yet
- add SecurityConfig class inside the config package, don't put anything related to security and user yet
- restart IDE if not beans can't be found

## Controller (no-auth yet)
- create a controller package inside the antiHero package
- write an AntiHeroController class inside the controller package

## REST-Client for Postman/Insomnia replacement
- add REST-Client folder in the root directory
- add an anti-heroes.http file inside the REST-Client folder
- send a get request, [] empty array should be the response
- send a post request
- send another get request, [{...}] should be the response

## Swagger UI or OpenAPI
- add springdoc-openapi-ui and springdoc-openapi-data-rest in the pom.xml
- add SwaggerConfig class inside the config package for custom Swagger UI
