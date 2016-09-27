package com.springapp.service;

import com.springapp.entity.Person;
import com.springapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 *
 */
@Service
public class PersonService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void createPerson() {
        Person person = new Person();
        person.setName("name");
        person.setSurname("surname");
        entityManager.persist(person);
    }

    @Transactional
    public void findPerson() {
        Person person2 = personRepository.findOneByName("name");
        //List<Person> persons  = personRepository.findAllByName("name");
        //persons  = personRepository.findAllByXz("surname");
        Person person = new Person();
        person.setName("name2");
        person.setSurname("surname2");
        personRepository.save(person);
    }


}
