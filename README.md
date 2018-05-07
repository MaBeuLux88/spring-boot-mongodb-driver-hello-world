# spring-boot-mongodb-driver-hello-world
Spring boot hello world project using directly the MongoDB Driver **without** Spring data MongoDB

# Why ?

It's a proof of concept.

The point was to prove we can use Spring boot starter web without Spring data MongoDB and still get a very simple code.

Spring data MongoDB hides most of the cool and powerful features of MongoDB and since 3.5.0, MongoDB Driver already have a POJO mapping capability.

# How to use

* Start a MongoDB node on localhost port 27017 (you can use the docker script)
* Start the application : 

```
mvn spring-boot:run
```

# Routes

* GET a person by ID
 
```bash
curl http://localhost:8080/api/person/5af0a5f70c9e5926c51cf2b5
```

* GET all the persons
 
```bash
curl http://localhost:8080/api/persons
```

* POST a person: 
 
```bash
curl http://localhost:8080/api/person -H "Content-type: application/json" -d '{"name":"Maxime Beugnet", "age": 30, "address": {"number": 123, "street" : "World Avenue", "postCode" : "12345", "town": "Paris"}, "hobbies": ["Scuba diving", "memes", "Java", "MongoDB"]}'
```

* POST a list of persons

```bash
curl http://localhost:8080/api/persons -H "Content-type: application/json" -d '[{"name":"Maxime Beugnet", "age": 30, "address": {"number": 123, "street" : "World Avenue", "postCode" : "12345", "town": "Paris"}, "hobbies": ["Scuba diving", "memes", "Java", "MongoDB"]}, {"name":"John Doe", "age": 42} ]'
```

* DELETE a person by ID

```bash
curl -X DELETE http://localhost:8080/api/person/5af0c2740c9e5926c51cf521
```

* DELETE all the persons

```bash
curl -X DELETE http://localhost:8080/api/persons
```

* UPDATE a person

```bash
curl -X PUT http://localhost:8080/api/person -H "Content-type: application/json" -d '{"id" : "5af0d0480c9e5926c51cf5ea", "name":"Maxime Beugnet", "age": 42, "address": {"number": 456, "street" : "World Street", "postCode" : "54321"}, "hobbies": ["Biking", "Memes", "Java", "MongoDB"]}'
```

# Problem

The *_id* field is automatically mapped to the *id* field. This is pretty misleading.
