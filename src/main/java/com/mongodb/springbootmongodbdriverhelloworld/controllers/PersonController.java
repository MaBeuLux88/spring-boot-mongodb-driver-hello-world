package com.mongodb.springbootmongodbdriverhelloworld.controllers;

import com.mongodb.springbootmongodbdriverhelloworld.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class PersonController {

    // private final PersonRepository personRepository;

    // public PersonController(PersonRepository personRepository) {
    //     this.personRepository = personRepository;
    // }

    @PostMapping("person")

    public void person(@RequestBody Person person) {
        // personRepository.insert(person);
    }

    @GetMapping("person/{id}")
    public Person person(@RequestParam String id) {
        // return personRepository.findOne(id);
        return null;
    }

}
