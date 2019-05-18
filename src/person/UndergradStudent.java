/*
 * Zachary Bax
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package person;

import enums.StudentYear;

/**
 * UndergradStudent class holds information about a undergraduate student
 * @author zacharybax
 *
 */
public class UndergradStudent extends Student {
	
	/**
	 * Constructor of UndergradStudent initializing first, last name and 
	 * student year. 
	 * @param firstName of undergraduate student
	 * @param lastName of undergraduate student
	 */
	public UndergradStudent(String firstName, String lastName) {
		super(firstName, lastName);
		this.studentYear = StudentYear.FRESHMAN;
	}
	
	/**
	 * Constructor of UndergradStudent initializing first, last name and 
	 * student year. 
	 * @param firstName of undergraduate student
	 * @param lastName of undergraduate student
	 * @param studentYear of undergraduate student
	 */
	public UndergradStudent(String firstName, String lastName, 
			StudentYear studentYear) {
		super(firstName, lastName);
		this.studentYear = studentYear;
	}
	
	/**
	 * Get student year of undergrad student
	 * @return student year of undergrad student
	 */
	public StudentYear getStudentYear() {
		return studentYear;
	}
	
	private StudentYear studentYear;
}
