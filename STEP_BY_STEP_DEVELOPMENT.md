# STEPS
## Project Starter
- check Java version by running `java -version`
- check if `java -version` returns `17.*`
- use spring initializr to create a new Spring Boot project
- add dependencies to such as Spring Boot DevTools, Lombok, Spring Web, Rest Repositories, Spring Security, Spring Data JPA, H2 Database, PostgreSQL Driver
- use Spring 2.6.0, Java 17, and Maven

## Tips
- press option + command + L to format your code
- get the maven packages by reloading the project using maven
- use docker client for database

## Entity
- add javax.validation in the pom.xml
- add spring-boot-starter-validation in the pom.xml
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
- write a ModelMapperConfig configuration inside the config package
- write CorsConfig configuration inside the config package, don't put anything related to security yet
- write SecurityConfig configuration inside the config package, don't put anything related to security and user yet
- The SecurityConfig removes the default login page of Spring Boot Security
- restart IDE if not beans can't be found

## Controller (no-auth yet)
- create a controller package inside the antiHero package
- write an AntiHeroController class inside the controller package
- create a DataLoader class to seed data into an empty database

## REST-Client for Postman/Insomnia replacement
- create REST-Client folder in the root directory
- write an anti-heroes.http file inside the REST-Client folder
- send/trigger GET http://localhost:8080/api/v1/anti-heroes, [] empty array should be the response
- send/trigger POST http://localhost:8080/api/v1/anti-heroes
- send/trigger another get request, GET http://localhost:8080/api/v1/anti-heroes, [{...}] should be the response

## Swagger UI or OpenAPI
- add springdoc-openapi-ui and springdoc-openapi-data-rest in the pom.xml
- write SwaggerConfig configuration inside the config package for custom Swagger UI
- update the application.properties with app.version, app.name, and app.description

## User
- create a user package under the com.example.superheroes folder
- write entity UserEntity class, user/entity/UserEntity.java
- write dto UserDto class, user/dto/UserDto.java
- write UserRepository interface, user/repository/UserRepository.java
- write a BadRequestException class inside the exception package
- write UserService interface, user/service/UserService.java
- write UserController class, user/controller/UserController.java

## JWT
- create jwt package under the com.example.superheroes folder
- create models package under the jwt folder
- write UserPrincipal class, jwt/models/UserPrincipal.java
- write AuthenticationRequest class, jwt/models/AuthenticationRequest.java
- write AuthenticationResponse class, jwt/models/AuthenticationResponse.java
- create services package under the jwt folder
- add jjwt-api, jjwt-impl, and jjwt-jackson in the pom.xml
- write an application.yml that has jwt secret in the resources
- write AppProperties configuration in config package. For jwt only for now.
- write PasswordConfig configuration in config package.
- update the SecurityConfig with userDetailsService, jwtFilter, configure, and http.addFilterBefore
- create filters package under the jwt folder
- write JwtFilter class, jwt/filters/JwtRequestFilter.java
- create controllers package under the jwt folder
- write AuthenticateController class, jwt/controllers/AuthenticateController.java
- write an auth.http file inside the REST-Client folder
- write a users.http file inside the REST-Client folder
- run the application
- trigger the POST http://localhost:8080/register
- check the response if an object is returned
- trigger the POST http://localhost:8080/authenticate
- check if a token is returned

## Protected endpoint
- add @PreAuthorize in the AntiHeroController
- send a get request to http://localhost:8080/api/v1/anti-heroes
- check if the response is 403 Forbidden
- login as a user by,
- triggering the POST http://localhost:8080/register
- triggering the POST http://localhost:8080/authenticate
- use the token in the Authorization header of REST-Client/anti-heroes.http
- send another get request to http://localhost:8080/api/v1/anti-heroes
- check if the response is 200 OK []

## Redis Caching
- add spring-data-redis and jedis in the pom.xml
- write RedisConfig configuration in config package.
- update the SuperheroesApplication class with @EnableCaching
- run the application

## Health Checks
- add spring-boot-starter-actuator in the pom.xml
- write health.http file inside the REST-Client folder
- trigger GET http://localhost:8080/actuator/health to see status UP

## Automated Tests
- add a resources package under the test folder
- in the resources package, write an application-test.properties
- create a repository package under the java/com.example.superheroes folder
- write a UserRepositoryTest class, repository/UserRepositoryTest.java
- create a service package under the java/com.example.superheroes folder
- write an AntiHeroServiceTest class, service/AntiHeroServiceTest.java
- run the tests in UserRepositoryTest and AntiHeroServiceTest

#### Adding Client Application
- write a MvcConfiguration configuration inside the config package
- create a directory and name it frontend
- go to the comment "START packaging spring and client app in one jar" of the pom.xml to see the config for Spring Boot with client application
- the fileset muse be mapped to the right directory of the frontend application
```xml
<fileset dir="${project.basedir}/frontend/dist/name-of-your-app"/>
```
- If using Angular, use dist/name-of-your-app directory to map Angular
- If using React, use build directory to map React
- For Angular, add the flag --prod into the npm run serve command to enable production mode

## Postgres SQL Database
- check if the docker client is running
- check if a postgres container is running
- create a new postgres database and name it springDevDb
- update the application.properties with the postgres database url etc.
- go to Run menu of Intellij IDE and select Edit Configuration
- click the plus button and select the Application
- name it SuperheroesApplication
- add the path of the main class which is SuperheroesApplication under com.example.superheroes
- add a new Environment variable and name it DATABASE_URL, DATABASE_USERNAME, and DATABASE_PASSWORD
- click apply and ok
- double-check the npm build of the Angular script has --prod flag
- run the application
- send POST http://localhost:8080/register
- send  POST http://localhost:8080/authenticate
- send GET http://localhost:8080/api/v1/anti-heroes, [] empty array should be the response
- send POST http://localhost:8080/api/v1/anti-heroes
- send GET http://localhost:8080/api/v1/anti-heroes, [{...}] should be the response
- send PUT http://localhost:8080/api/v1/anti-heroes/{:id}
- full crud should be working
- https://www.mockaroo.com to generate SQL queries

## Unit and Integration Tests
- setup application.properties for the unit and integration tests inside the src/test/resources folder
- add javafaker in the pom.xml
- start writing tests for services and for controllers

## Heroku
- create a GitHub account
- create a Heroku account
- create a new app on Heroku and choose your region without pipeline
- create a new postgres database on Heroku by using the add-on Postgres
- connect the database to the app
- create tables for the database through here https://data.heroku.com/dataclips
- copy the sql scripts from the sql file in the root folder and paste it on the dataclips query dashboard
- you can also create your own sql scripts and paste them on the dataclips query dashboard
- add a system.properties file in the root directory
- add a GitHub secret, HEROKU_API_KEY, for the heroku api key which can be found on your account settings
- add a JWT_SECRET in the heroku's settings -> config vars

## GitHub Actions
- create a GitHub workflow yml file
- see https://github.com/marketplace/actions/deploy-to-heroku
- rename your master branch to main branch on the branches page of your GitHub Repo
- future push to your repo will deploy to Heroku