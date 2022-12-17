package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository repository;
    @Autowired
    public PersonService (PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public Iterable<Person> getPersonList() {
        return repository.findAll();
    }

    public Person getPerson(int id) {
        return repository.findById(id).get();
    }

    public Person updatePerson(int id, Person newPersonData) {
        Person originalPerson = repository.findById(id).get();
        originalPerson.setFirstName(newPersonData.getFirstName());
        originalPerson.setLastName(newPersonData.getLastName());
        return repository.save(originalPerson);
    }

    public Boolean deletePerson(int id) {
        repository.deleteById(id);
        return true;
    }

}
