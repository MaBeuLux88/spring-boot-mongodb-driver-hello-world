package com.mongodb.springbootmongodbdriverhelloworld.repositories;

import com.mongodb.springbootmongodbdriverhelloworld.models.Person;

import java.util.List;

public interface PersonRepository {

    Person insert(Person person);

    Person findOne(String id);

    List<Person> findAll();

    List<Person> insertMany(List<Person> persons);

    Person delete(String id);

    void deleteAll();

    Person update(Person person);
}
