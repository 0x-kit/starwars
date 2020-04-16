
## Quickstart

###### About
    This project aims to develop a RESTFul API about Star Wars characters while applying principles of Domain Driven Design and Hexagonal Architecture. 
    It is written in java8 under spring-boot web framework and it just accepts requests only of this type: 
       curl --request GET \
          --url 'http://{host}:{port}/swapi-proxy/person-info?name=Luke%20Skywalker'
    
    
###### Run the app
    gradle bootRun
    
###### How to deploy this on a live system
    gradle build
    java -jar starwars-boot/build/libs/starwars-boot-0.0.1-SNAPSHOT.jar 
    
###### Run the app within a docker container
    docker build -t starwars-docker .
    docker run -p 8080:8080 -d starwars-docker
    
    
###### Running the tests
    gradle test

      
### Code project structure
- ``starwars-boot`` entry point for the application, with spring boot dependencies
- ``starwars-domain``: where business logic resides
- ``starwars-infrastructure`` implementation details with the *external world*


### Dependencies
- Java 8
- Gradle
