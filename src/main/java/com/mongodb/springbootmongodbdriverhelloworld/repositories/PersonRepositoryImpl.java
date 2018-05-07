package com.mongodb.springbootmongodbdriverhelloworld.repositories;

// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.models.Filters;

import com.mongodb.springbootmongodbdriverhelloworld.models.Person;

public class PersonRepositoryImpl implements PersonRepository {

    // private final MongoCollection<Person> personCollection;

    public PersonRepositoryImpl(/*MongoClient mongoClient*/) {
        // MongoDatabase db = mongoClient.getDatabase("test");
        // personCollection = db.getCollection("person", Person.class);
        // personCollection = null;
    }

    public void insert(Person person) {
        // personCollection.insertOne(person);
    }

    public Person findOne(String id) {
        return null;/*personCollection.find(Filters.eq("_id", id)).first();*/
    }
}
