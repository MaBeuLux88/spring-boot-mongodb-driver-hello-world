package com.mongodb.springbootmongodbdriverhelloworld.controllers;

import com.mongodb.springbootmongodbdriverhelloworld.models.Person;
import com.mongodb.springbootmongodbdriverhelloworld.repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable String id) {
        return ResponseEntity.ok(personRepository.findOne(id));
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons() {
        return ResponseEntity.ok(personRepository.findAll());
    }

    @PostMapping("/person")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        Person inserted = personRepository.insert(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(inserted);
    }

    @PostMapping("/persons")
    public ResponseEntity<List<Person>> postPersons(@RequestBody List<Person> persons) {
        List<Person> inserted = personRepository.insertMany(persons);
        return ResponseEntity.status(HttpStatus.CREATED).body(inserted);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable String id) {
        Person deleted = personRepository.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

    @DeleteMapping("/persons")
    public ResponseEntity<Void> deletePersons() {
        personRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/person")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        if (person.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        boolean personNotFound = personRepository.findOne(person.getId().toHexString()) == null;
        if (personNotFound)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else {
            Person updated = personRepository.update(person);
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        }
    }

}
