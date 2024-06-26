package com.example.demo.data.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")

public class Person implements  Serializable {

	private  static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id ;
	
	
	@JsonProperty("first_name")
	@Column(name = "first_name", nullable = false , length =  80)
	private String firstName;
	
	
	@JsonProperty("last_name")
	@Column(name = "last_name" , nullable =  false , length = 80)
	private String lastName;
	
	@Column(name = "address" , nullable =  false , length = 100)
	private String address;
	
	@JsonIgnore
	@Column(name = "gender", nullable =  false , length = 6)
	private String gender;
	
	
    public Person() {
    }

	public Person(Long id, String firstName, String lastName, String address, String gender) {
	
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	  @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((address == null) ? 0 : address.hashCode());
	        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
	        result = prime * result + ((id == null) ? 0 : id.hashCode());
	        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Person other = (Person) obj;
	        if (address == null) {
	            if (other.address != null)
	                return false;
	        } else if (!address.equals(other.address))
	            return false;
	        if (firstName == null) {
	            if (other.firstName != null)
	                return false;
	        } else if (!firstName.equals(other.firstName))
	            return false;
	        if (gender == null) {
	            if (other.gender != null)
	                return false;
	        } else if (!gender.equals(other.gender))
	            return false;
	        if (id == null) {
	            if (other.id != null)
	                return false;
	        } else if (!id.equals(other.id))
	            return false;
	        if (lastName == null) {
	            if (other.lastName != null)
	                return false;
	        } else if (!lastName.equals(other.lastName))
	            return false;
	        return true;
	    }
	
	
	
	
}
