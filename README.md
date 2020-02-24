s4dx
==============

REST API based on Spring Boot containing requests for CRUD operations (Create, Read, Update and Delete) for XDevices and HCP offices.

# Create the DB Schema

Create the `s4dx_db` schema in the database as follows:
```
CREATE DATABASE `s4dx_db`;
```

# Building a Stand Alone Jar

### With Maven

```
mvn clean install
```

# Running the Service

### Running as a packaged application

```
java -jar target/s4dx-xdevice-<version>.jar
```

### With Maven plugin

```
mvn spring-boot:run
```

# Swagger Console

Further documentation for the endpoints can be found at: [http://localhost:8087/s4dx/swagger-ui.html](http://localhost:8087/s4dx/swagger-ui.html)
