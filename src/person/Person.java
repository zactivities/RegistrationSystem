/*
 * Zachary Bax
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package person;

import enums.PersonStatus;

/**
 * The Person class holds the first and last name, status, email and id of
 * a person. 
 * @author zacharybax
 *
 */
public class Person {
	
	/**
	 * Constructor for person, initializing firstName, lastName, email, status
	 * and id.
	 * @param firstName of person
	 * @param lastName of person
	 * @param email of person
	 */
	public Person(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = PersonStatus.ACTIVE;
		this.email = email;
		this.id = nextId++;
	}
	
	/**
	 * Constructor for person, initializing firstName, lastName, email, status
	 * and id.
	 * @param firstName of person
	 * @param lastName of person
	 */
	public Person (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = PersonStatus.ACTIVE;
		this.email = lastName.toLowerCase()+firstName.toLowerCase()
					.charAt(0) + "@seattleu.edu";
		this.id = nextId++;
	}
	
	/**
	 * Get first name of person
	 * @return first name of person
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Get last name of person
	 * @return last name of person
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Get identification number of person
	 * @return identification number of person
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Get email of person
	 * @return email of person
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Get status of person
	 * @return either ACITVE or INACTIVE 
	 */
	public PersonStatus getStatus() {
		return status;
	}
	
	/**
	 * Set status of person
	 * @param status is either ACTIVE or INACTIVE 
	 */
	public void setStatus(PersonStatus status) {
		this.status = status;
	}

	private PersonStatus status;
	private String email;
	private int id;
	private static int nextId = 1;
	private String firstName;
	private String lastName;
}
