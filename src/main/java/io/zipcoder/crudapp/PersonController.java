package io.zipcoder.crudapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service= service;
    }

    @RequestMapping(value = "/people/post", method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(service.create(p), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        return new ResponseEntity<>(service.getPerson(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(service.getPersonList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person p) {
        return new ResponseEntity<>(service.updatePerson(id, p), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean>deletePerson(@PathVariable int id) {
        return new ResponseEntity<>(service.deletePerson(id), HttpStatus.NO_CONTENT);
    }


}
