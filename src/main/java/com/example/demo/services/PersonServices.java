package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.model.Person;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.PersonRepositories;

@Service		// um objeto runtime que vai ser injetado em outras classes da aplicação
public class PersonServices {
    
		@Autowired
		PersonRepositories repository;	
	

    
		
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}	
	
	public Person findById(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
		
	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}