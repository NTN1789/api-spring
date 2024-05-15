package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Person;

@Repository
public interface PersonRepositories extends JpaRepository<Person, Long> {

}
