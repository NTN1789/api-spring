package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.PersonController;
import com.example.demo.data.model.Person;
import com.example.demo.data.model.Vo.PersonVo;
import com.example.demo.data.model.Vo.V2.PersonVOV2;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.mapper.custom.PersonConverter;
import com.example.demo.repositories.PersonRepositories;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service		// um objeto runtime que vai ser injetado em outras classes da aplicação
public class PersonServices {
    
		@Autowired
		PersonRepositories repository;	
	


		@Autowired
		PersonConverter converter;
		
	public PersonVo create(PersonVo person) {
		var entity = DozerMapper.parseObject(person, Person.class);
		var  vo  = DozerMapper.parseObject(repository.save(entity), PersonVo.class);
		return  vo;
	}
	
	
	
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.convertVOToEntity(person) ;
		var  voTwo = converter.convertEntityToVO(repository.save(entity));
		return  voTwo;
	}
	
	
	
	public List<PersonVo> findAll() {
		return DozerMapper.parseListObject(repository.findAll(), PersonVo.class);
	}	
	
	public PersonVo findById(Long id) {

	  var entitry = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	  
	 PersonVo vo =  DozerMapper.parseObject(entitry, PersonVo.class);
	
	 vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
	 
	 return vo;
	 }
	
		
	public PersonVo update(PersonVo person) {
		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVo.class);
		return vo;
	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}