package com.mongodb.springbootmongodbdriverhelloworld.repositories;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.springbootmongodbdriverhelloworld.models.Person;
import org.bson.BsonDocument;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Repository
public class MongoDBPersonRepository implements PersonRepository {

    private final MongoCollection<Person> personCollection;

    public MongoDBPersonRepository(MongoClient mongoClient) {
        MongoDatabase db = mongoClient.getDatabase("test");
        personCollection = db.getCollection("person", Person.class);
    }

    @Override
    public Person insert(Person person) {
        person.setId(new ObjectId());
        personCollection.insertOne(person);
        return person;
    }

    @Override
    public Person findOne(String id) {
        return personCollection.find(Filters.eq("_id", new ObjectId(id))).first();
    }

    @Override
    public List<Person> findAll() {
        FindIterable<Person> people = personCollection.find();
        List<Person> persons = new ArrayList<>();
        people.forEach((Consumer<Person>) persons::add);
        return persons;
    }

    @Override
    public List<Person> insertMany(List<Person> persons) {
        persons.forEach(p -> p.setId(new ObjectId()));
        personCollection.insertMany(persons);
        return persons;
    }

    @Override
    public Person delete(String id) {
        return personCollection.findOneAndDelete(Filters.eq("_id", new ObjectId(id)));
    }

    @Override
    public void deleteAll() {
        personCollection.deleteMany(new BsonDocument());
    }

    @Override
    public Person update(Person person) {
        return personCollection.findOneAndReplace(Filters.eq("_id", person.getId()), person);
    }
}
