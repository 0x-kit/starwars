
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
## Quickstart

###### About
This project aims to develop a RESTFul API about Star Wars characters while applying principles of Domain Driven Design and Hexagonal Architecture. 

It is written in java8 under spring-boot web framework and it just accepts requests only of this type: 

    curl --request GET \
          --url 'http://{host}:{port}/swapi-proxy/person-info?name=Luke%20Skywalker'

```json
{
  "name": "Luke Skywalker",
  "birth_year": "19BBY",
  "gender": "male",
  "planet_name": "Tatooine",
  "fastest_vehicle_driven": "X-wing",
  "films": [
    {
      "name": "A New Hope",
      "release_date": "1977-05-25"
    },
    {
      "name": "The Empire Strikes Back",
      "release_date": "1980-05-17"
    },
    {
      "name": "Return of the Jedi",
      "release_date": "1983-05-25"
    },
    {
      "name": "Revenge of the Sith",
      "release_date": "2005-05-19"
    },
    {
      "name": "The Force Awakens",
      "release_date": "2015-12-11"
    }
  ]
}
```

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
