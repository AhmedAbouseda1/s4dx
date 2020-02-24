S4DX
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


## Get list of X Devices

### Request

    curl -X GET "http://localhost:8087/s4dx/v1/xdevice/" -H  "accept: application/json"

### Response
    Request Header :

    code 200
    connection: keep-alive  
    content-type: application/json  
    date: Mon, 24 Feb 2020 17:51:49 GMT  
    keep-alive: timeout=60  
    transfer-encoding: chunked 

    Response body :

    [
      {
        "id": 7,
        "manufacturerId": "string",
        "hcpId": 0,
        "hardwareState": "string"
      }
    ]

## Create a X Device

### Request
    
    curl -X POST "http://localhost:8087/s4dx/v1/xdevice/" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{  \"hardwareState\": \"string\",  \"hcpId\": 0,  \"id\": 0,  \"manufacturerId\": \"string\"}"

### Response
    Request Header :
    code 200

    connection: keep-alive  
    content-type: application/json  
    date: Mon, 24 Feb 2020 17:55:29 GMT  
    keep-alive: timeout=60  
    transfer-encoding: chunked 
    
    Response Body:
    {
      "id": 9,
      "manufacturerId": "2323",
      "hcpId": 0,
      "hardwareState": "string"
    }
## Delete a X Device

### Request

    curl -X DELETE "http://localhost:8087/s4dx/v1/xdevice/7" -H  "accept: application/json"

### Response
    Request Header :

     code 200
     connection: keep-alive  
     content-length: 0  
     date: Mon, 24 Feb 2020 17:58:42 GMT  
     keep-alive: 
     timeout=60 
     
     
     
## Update a X Device
     
### Request
     
    curl -X PUT "http://localhost:8087/s4dx/v1/xdevice/9" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{  \"hardwareState\": \"string\",  \"hcpId\": 0,  \"id\": 0,  \"manufacturerId\": \"string\"}"     

### Response
        Request Header :
         code 200
          connection: keep-alive  
          content-length: 0  
          date: Mon, 24 Feb 2020 17:58:42 GMT  
          keep-alive: 
          timeout=60 
          
         Request Body :
         
          {
            "id": 9,
            "manufacturerId": "string",
            "hcpId": 0,
            "hardwareState": "string"
          }
