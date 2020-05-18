#### Stack requirements
* Java 8
* Gradle 5.6.4
* Quarkus

#### Tasks
* runPostgres
* quarkusDev
* killPostgres
 
Database is dropped and created for each boot of the application.

Annotation processing has to be enabled in IntelliJ IDEA.
 
#### Test

Create event: 
```
curl -X PUT -H "Content-Type: application/json" localhost:8081/rest/event -d '{"id":"test","message":"test message"}'
```

Get event:
```
curl -X GET -H "Content-Type: application/json" localhost:8081/rest/event/test
```