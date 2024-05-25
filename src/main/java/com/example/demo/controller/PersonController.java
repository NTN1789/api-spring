package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import com.example.demo.data.model.Vo.PersonVo;
import com.example.demo.data.model.Vo.V2.PersonVOV2;
import com.example.demo.services.PersonServices;

@RestController
@RequestMapping ("/api/person/v1")
public class PersonController {
    
    @Autowired
    private PersonServices service;
    
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVo> findAll() {
        return service.findAll();
    }    
    
    @GetMapping(value="/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo findById(@PathVariable Long id) {
        return service.findById(id);
    }    
    
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo create(@RequestBody PersonVo person) {
        return service.create(person);
    }
    
    
    
	@PostMapping("/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return service.createV2(person);
	}
    
    
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo update(@RequestBody PersonVo person) {
        return service.update(person);
    }    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }    
    
}