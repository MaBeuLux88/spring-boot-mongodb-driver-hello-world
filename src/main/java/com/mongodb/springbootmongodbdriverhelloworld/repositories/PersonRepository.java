package com.mongodb.springbootmongodbdriverhelloworld.repositories;

import com.mongodb.springbootmongodbdriverhelloworld.models.Person;

public interface PersonRepository {

    void insert(Person person);

    Person findOne(String id);
}
