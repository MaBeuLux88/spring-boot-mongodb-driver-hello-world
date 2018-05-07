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
    public ResponseEntity<Void> postPerson(@RequestBody Person person) {
        personRepository.insert(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/persons")
    public ResponseEntity<Void> postPersons(@RequestBody List<Person> persons) {
        personRepository.insertMany(persons);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String id) {
        personRepository.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/persons")
    public ResponseEntity<Void> deletePersons() {
        personRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/person")
    public ResponseEntity<Void> updatePerson(@RequestBody Person person) {
        if (person.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        boolean personNotFound = personRepository.findOne(person.getId().toHexString()) == null;
        if (personNotFound)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else {
            personRepository.update(person);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

}
