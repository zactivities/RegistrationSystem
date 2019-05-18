/*
 * Zachary Bax
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package person;

import enums.Building;
import enums.FacultyType;

/**
 * The Faculty class holds information about a faculty member.
 * 
 * - first name: first name of the student
 * - last name: last name of the student
 * - suid: Seattle U identification number
 * - status: the status of the faculty (see PersonStatus enum)
 * - faculty type: the type of faculty (see FacultyType enum)
 * - office: includes building (i.e. ENGR) and room number (i.e 504)
 * - email: the school (i.e. SU) email address
 * 
 * @author zacharybax
 */
public class Faculty extends Person {

	/**
	 * Constructor initializing faculty first and last name
	 * @param firstName	The first name of the faculty
	 * @param lastName	The last name of the faculty
	 */
	public Faculty(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	/**
	 * Constructor initializing faculty first, last name, and email
	 * @param firstName	The first name of the faculty 
	 * @param lastName	The last name of the faculty
	 * @param email The email of the faculty
	 */
	public Faculty(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}
	
	/**
	 * Get faculty type of faculty 
	 * @return faculty type
	 */
	public FacultyType getType() {
		return type;
	}

	/**
	 * Set faculty type of faculty
	 * @param type of faculty
	 */
	public void setType(FacultyType type) {
		this.type = type;
	}

	/**
	 * Get building of faculty
	 * @return building of faculty
	 */
	public Building getBuilding() {
		return bldg;
	}

	/**
	 * Set building of faculty
	 * @param bldg building of faculty
	 */
	public void setBuidling(Building bldg) {
		this.bldg = bldg;
	}

	/**
	 * Set room of faculty
	 * @param room of faculty
	 */
	public void setRoom(int room) {
		this.room = room;
	}
	
	/**
	 * Get room of faculty
	 * @return room of faculty
	 */
	public int getRoom() {
		return room;
	}
	
	/**
	 * Print data about faculty
	 */
	@Override
	public String toString() {
		return String.format("%-3d %-12s %-10s %-17s %-10s %-8d %-10s", 
				super.getId(), super.getFirstName(), super.getLastName(),
				type.toString(), bldg.toString(), room, 
				super.getEmail());	
	}

	private FacultyType type;
	private Building bldg;
	private int room;
}
