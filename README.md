# REST+SOAP Services mit Spring Boot

REST service usually are implemented by a code first approach. 
To use a code first approach to implement a SOAP service Apache CXF should be used.

### Integration of Apache CXF


Apache CXF provides a dependency:

```
<dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-spring-boot-starter-jaxws</artifactId>
    <version>3.1.11</version>
</dependency>
```

### Spring Boot Profile

The following Profile

- `soap` - activate the SOAP Endpoint
- `swagger` - activate Swagger Endpoint and UI


### Swagger UI
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### WSDL Endpoint
[http://localhost:8080/services/](http://localhost:8080/services/)

### Literatur
[http://cxf.apache.org/docs/springboot.html](http://cxf.apache.org/docs/springboot.html)
