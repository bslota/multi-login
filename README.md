# About
Multi-login is an example of how to configure Spring Security
so that we have different login pages for different URL path
patterns. It also shows how to test such configuration.
This project is described in one of my blog posts:
bartslota.blogspot.com 

# Building
    mvn clean install
    
# Running
## Maven
    mvn spring-boot:run
## Maven wrapper
### Windows
    mvnw spring-boot:run
### Linux
    ./mvnw spring-boot:run
## Java
    java -jar target/multi-login-0.0.1-SNAPSHOT.jar
    
# Usage
* Regular home page: localhost:8080/regular/home
* Regular login page: localhost:8080/regular/login
* Special home page: localhost:8080/special/home
* Special login page: localhost:8080/special/login
