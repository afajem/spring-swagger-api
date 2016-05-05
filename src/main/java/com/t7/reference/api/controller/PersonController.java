package com.t7.reference.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.t7.reference.api.domain.Person;
import com.t7.reference.api.domain.PersonRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Fetch a list of people
	 * @return a list of people
	 */
    @RequestMapping(path="/all", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch all people")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")}) 
    public List<Person> people() {
    	List<Person> people = (List<Person>) personRepository.findAll();
    	
    	return people;
    }
    
    
    /**
     * Finds a person by <code>id</code>
     * 
     * @param id person's id
     * 
     * @return the {@link Person} object
     */
    @RequestMapping(path = "/{id}", 
    				method = RequestMethod.GET)
    @ApiOperation(value = "Fetch a person")
    public Person person(@PathVariable Long id) {
    	return personRepository.findOne(id);
    }
    
    
    /**
     * Adds a person
     * 
     * @param person
     * @return
     */
    @RequestMapping(path = "/add",
    				method = RequestMethod.POST,
    				 consumes =  MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a person")
    public Person add(@RequestBody Person person) {
    	Person savedPerson =  personRepository.save(person);
    	
    	return savedPerson;
    }

    
    /**
     * Updates the person
     * 
     * @param person
     * @return
     */
    @RequestMapping(path = "/update",
    				method = RequestMethod.PUT)
    @ApiOperation(value = "Update a person")
    public Person update(@RequestBody Person person) {
    	Person savedPerson =  personRepository.save(person);
    	
    	return savedPerson;
    }
    
    
    /**
     * Deletes person identified with <code>id</code>
     * @param id
     */
    @RequestMapping(path = "/{id}", 
			method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a person")
    public void delete(@PathVariable Long id) {
    	personRepository.delete(id);
    }

}
