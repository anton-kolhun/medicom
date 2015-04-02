package com.springapp.repository;


import com.springapp.entity.Person;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends Repository<Person, String>
{

    Person findOneByName(String name);

    List<Person> findAllByName(String name);

    @Query("SELECT p FROM Person p where p.surname = :surname")
    List<Person> anyMethodName(@Param("surname") String surname);

    List<Person> findAll();

    Person save(Person person);

    Integer deleteByName(String name);

    Integer removeBySurname(String name);
}
