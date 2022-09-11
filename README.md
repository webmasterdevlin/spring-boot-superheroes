## Spring Boot API for Heroes application
- Java 17
- Lombok in Villain module
- Prettier Java
- JPA
- Postgres 13
- Open Api 3
- Logging
  - slf4j in Hero module
  - log4j2 in Villain module  
- JWT Auth
    - Anti-Heroes is protected
- JUnit Testing with Assertj
- Redis in Villain module

#### Swagger ui
- http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

#### Packaging Locally
- use Java 17
- you can use sdkman for sdk which is a java versions management

```zsh
sdk list java
sdk install java 17.0.3-tem 
sdk use java 17.0.3-tem 
```

- install maven
- move angular project to the root directory of Spring Boot 2 named frontend or client-app or whatever
- go to root directory of Spring Boot 2 and run the below commands
```zsh
mvn clean
mvn package
 ```
- go to target directory and run the below commands
```zsh
java -jar target/name-of-your-apps-jar-file-0.0.1.jar
```
or just run your IntelliJ IDEA
- check localhost:8080



#### More info
- https://frakton.com/utilizing-maven-front-end-plugin-for-angular-spring-boot/
- https://www.kantega.no/blogg/webapp-with-create-react-app-and-spring-boot
- https://github.com/eirslett/frontend-maven-plugin