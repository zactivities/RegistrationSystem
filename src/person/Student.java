/*
 * Zachary Bax
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package person;

import enums.Quarter;
import enums.StudentProgram;
import enums.StudentType;

/**
 * The Student class holds information about a student. 
 * 
 * - first name: first name of the student
 * - last name: last name of the student
 * - suid: Seattle U identification number
 * - status: the status of the student (see PersonStatus enum)
 * - student type: a student can only be assigned a single student type
 *   (see StudentType enum)
 * - student program: a student can only be assigned to a single program at 
 *   a point of time, but can switch from one program to another (i.e. when 
 *   they've graduated from a program (see StudentProgram enum)
 * - student year: only relevant for undergraduates (see StudentYear enum)
 * - faculty advisor: students are assigned a faculty advisor, but may switch 
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student
 * - start term: associated with the quarter and year a student starts a
 *   particular program; for example, a single student may start the CERT in 
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)
 * - email: the school (i.e. SU) email address
 * 
 * @author zacharybax
 */
public class Student extends Person {

	/**
	 * Constructor for student, initializing first, last name, student type, 
	 * student program, student advisor, student start quarter and the year
	 * @param firstName	The first name of the student
	 * @param lastName	The last name of the student
	 */
	public Student(String firstName, String lastName) {
		super(firstName, lastName);
		this.type = null;
		this.program = null;
		this.advisor = null;
		this.startQuarter = null;
		this.year = 2018;
	}
	
	/**
	 * Get type of student
	 * @return type of student
	 */
	public StudentType getType() {
		return type;
	}
	
	/**
	 * Set type of student
	 * @param type of student
	 */
	public void setType(StudentType type) {
		this.type = type;
	}
	
	/**
	 * Get program of student
	 * @return program of student
	 */
	public StudentProgram getProgram() {
		return program;
	}
	
	/**
	 * Set program of student
	 * @param program of student
	 */
	public void setProgram(StudentProgram program) {
		this.program = program;
	}
	
	/**
	 * Get advisor of student
	 * @return advisor of student
	 */
	public Faculty getAdvisor() {
		return advisor;
	}
	
	/**
	 * Set advisor of student
	 * @param advisor of student
	 */
	public void setAdvisor(Faculty advisor) {
		this.advisor = advisor;
	}
	
	/**
	 * Set start quarter of student
	 * @return start quarter of student
	 */
	public Quarter getStartQuarter() {
		return startQuarter;
	}
	
	/**
	 * Set start quarter of student
	 * @param startQuarter of student
	 */
	public void setStartQuarter(Quarter startQuarter) {
		this.startQuarter = startQuarter;
	}

	/**
	 * Get year of student
	 * @return year of student 
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Set year of student
	 * @param year of student
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Print all fields for student
	 */
	@Override
	public String toString() {
		return String.format("%-3d %-12s %-10s %-17s %-10s %-8s %-8d %-10s", 
				super.getId(), super.getFirstName(), super.getLastName(),
				type.toString(), program.toString(), startQuarter.toString(), 
				year, super.getEmail());	
	}

	private int year;
	private StudentType type;
	private StudentProgram program;
	private Faculty advisor;
	private Quarter startQuarter;
}
