# Proof of Concept
# REST+SOAP Services mit Spring Boot

#### Integration of Apache CXF

Da REST Services werden mit einem Code-First-Ansatz implementiert. Daher wird auch bei der Bereitstellung von REST und SOAP Services ein Code First-Ansatz empfohlen.

Für die Implementierung wird Apache CXF empfohlen. Diese bietet eine passenden Spring Boot Starter an:

```
<dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-spring-boot-starter-jaxws</artifactId>
    <version>3.1.11</version>
</dependency>
```



### Spring Boot Profile

- `soap` - activate the SOAP Endpoint
- `swagger` - aktivate Swagger Endpoint and UI


### Swagger UI

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


### WSDL Endpoint

[http://localhost:8080/services/](http://localhost:8080/services/)

### Literatur

[http://cxf.apache.org/docs/springboot.html](http://cxf.apache.org/docs/springboot.html)