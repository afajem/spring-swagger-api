package com.t7.reference.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false)
	private int age;
	

	protected Person() {
	     // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }
	
	
	public Person(String firstname, String lastname, int age) {
		this.firstname = firstname;
		this.lastname = firstname;
		this.age = age;
	}

	
	public Long getId() {
		return id;
	}
	
	
    @ApiModelProperty(notes = "The first name of a person", required = true)
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


    @ApiModelProperty(notes = "The last name of a person", required = true)
	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


    @ApiModelProperty(notes = "The age of a person", required = true)
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

}
