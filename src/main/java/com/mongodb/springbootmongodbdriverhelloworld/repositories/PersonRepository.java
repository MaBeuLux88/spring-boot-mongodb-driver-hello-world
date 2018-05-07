package com.mongodb.springbootmongodbdriverhelloworld.repositories;

import com.mongodb.springbootmongodbdriverhelloworld.models.Person;

import java.util.List;

public interface PersonRepository {

    void insert(Person person);

    Person findOne(String id);

    List<Person> findAll();

    void insertMany(List<Person> persons);

    void delete(String id);

    void deleteAll();

    void update(Person person);
}
