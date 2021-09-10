## Spring Boot API for Heroes application
- Java 11
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


#### Package Spring Boot and Angular in one Jar
- create a directory and name it frontend or client-app
- use dist/name-of-your-app directory for Angular or build directory for React in
```xml
<fileset dir="${project.basedir}/frontend/dist/name-of-your-app"/>
```
- add proxies in the package.json of Angular

```json
{
  "proxy": {
    "/api": {
      "target": "http://localhost:8080/api",
      "ws": true
    },
    "/authenticate": {
      "target": "http://localhost:8080/authenticate",
      "ws": true
    },
    "/register": {
      "target": "http://localhost:8080/register",
      "ws": true
    }
  }
}
```
- add a MvcConfiguration class in Spring Boot backend targeting public folder


#### Packaging Locally
- use Java 16
- you can use sdkman for sdk and java versions management
- install maven
- move angular project to the root directory of Spring Boot 2 named frontend or client-app or whatever
- go to root directory of Spring Boot 2 and run the below commands
```zsh
mvn clean
mvn package
 ```
- go to target directory and run the below commands
```zsh
jar -jar name-of-your-apps-jar-file-0.0.1.jar
```
or just run your IntelliJ IDEA
- check localhost:8080



#### More info
- https://frakton.com/utilizing-maven-front-end-plugin-for-angular-spring-boot/
- https://www.kantega.no/blogg/webapp-with-create-react-app-and-spring-boot
- https://github.com/eirslett/frontend-maven-plugin