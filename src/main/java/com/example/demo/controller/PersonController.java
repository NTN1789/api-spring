package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import com.example.demo.data.model.Vo.PersonVo;
import com.example.demo.data.model.Vo.V2.PersonVOV2;
import com.example.demo.services.PersonServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@RequestMapping ("/api/person/v1")

@Tag(name = "Pessoas", description =  "Endpoints for managing people ")
public class PersonController {
    
    @Autowired
    private PersonServices service;
    
    

    @GetMapping(
            produces =   { "application/json", "application/xml", "application/x-yaml" }) 
   @Operation(summary =  "finds all people ", description = "pegar pessoas " , 
   tags =  {"People"},
   responses = { 
		   @ApiResponse( description = "Success" ,responseCode = "200"  , content = {
				    @Content(
				    			mediaType =   "application/json",
				    			array =  @ArraySchema(schema =  @Schema(implementation = PersonVo.class))
				    		)
		   }),
		   @ApiResponse( description = "Bad Request" ,responseCode = "400"  , content = @Content),
		   @ApiResponse( description = "Unauthorized" ,responseCode = "401"  , content = @Content),
		   @ApiResponse( description = "Not found" ,responseCode = "404"  , content = @Content),
		   @ApiResponse( description = "Internal error" ,responseCode = "500"  , content = @Content)
   }
   
		   )
    public List<PersonVo> findAll() {
        return service.findAll();
        
    
    }    
    
    

    @GetMapping(value="/{id}",
            produces = { "application/json", "application/xml", "application/x-yaml" })
    
    
    @Operation(summary =    "finds a person ", description = "pegar pessoas por id  ", 
    tags =  {"Peolpe"},
    		responses = { 
    				   @ApiResponse( description = "Success" ,responseCode = "200"  ,content = @Content(
    					schema =  @Schema(implementation = PersonVo.class))),
    				   @ApiResponse( description = "No content" ,responseCode = "204"  , content = @Content),
    				   @ApiResponse( description = "Bad Request" ,responseCode = "400"  , content = @Content),
    				   @ApiResponse( description = "Unauthorized" ,responseCode = "401"  , content = @Content),
    				   @ApiResponse( description = "Not found" ,responseCode = "404"  , content = @Content),
    				   @ApiResponse( description = "Internal error" ,responseCode = "500"  , content = @Content)
    		   }
    
    		)
    
    
    public PersonVo findById(@PathVariable Long id) {
        return service.findById(id);
    }    
    
    
 
    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    
    @Operation(summary =    "create a person ", description = "criar pessoas  ", 
    tags =  {"Peolpe"},
    		responses = { 
    				   @ApiResponse( description = "Success" ,responseCode = "200"  ,content = @Content(
    					schema =  @Schema(implementation = PersonVo.class))),
    				   @ApiResponse( description = "No content" ,responseCode = "204"  , content = @Content),
    				   @ApiResponse( description = "Bad Request" ,responseCode = "400"  , content = @Content),
    				   @ApiResponse( description = "Unauthorized" ,responseCode = "401"  , content = @Content),
    				   @ApiResponse( description = "Not found" ,responseCode = "404"  , content = @Content),
    				   @ApiResponse( description = "Internal error" ,responseCode = "500"  , content = @Content)
    		   }
    )
    public PersonVo create(@RequestBody PersonVo person) {
        return service.create(person);
    }
    
    
    
	@PostMapping("/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return service.createV2(person);
	}
    
    

    @PutMapping(
    		produces = { "application/json", "application/xml", "application/x-yaml" }, 
            consumes =  { "application/json", "application/xml", "application/x-yaml" })
    public PersonVo update(@RequestBody PersonVo person) {
        return service.update(person);
    }    
    
	

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }    
    
}