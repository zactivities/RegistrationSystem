/*
 * Zachary Bax
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package registration;

import java.util.ArrayList;

import enums.SubjectCode;

/**
 * The Course class holds information about a course.
 * 
 * For example, CPSC 5011: Object-Oriented Concepts
 * - subject code: CPSC
 * - course number: 5011
 * - course name: Object-Oriented Concepts
 * - credit number: 3
 * - prerequisite(s): CPSC 5003 (can have multiple prerequisites or none)
 * 
 * @author zacharybax
 */
public class Course {
	
	/**
	 * Constructor for Course, initializing course code, courseNum, name,
	 * and creditNum.
	 * @param code		The subject code of the course
	 * @param courseNum	The course number of the course
	 * @param name		The course name
	 * @param creditNum The number of the credits of the course
	 */
	public Course(SubjectCode code, int courseNum, String name, 
					int creditNum) {
		this.code = code;
		this.courseNum = courseNum;
		this.name = name;
		this.creditNum = creditNum;
		this.prereqList = new ArrayList<>();
	}

	/**
	 * Get subject code of course
	 * @return subject code of course
	 */
	public SubjectCode getCode() {
		return code;
	}
	
	/**
	 * Get course number of course
	 * @return course number of course
	 */
	public int getCourseNum() {
		return courseNum;
	}
	
	/**
	 * Get name of course
	 * @return name of course
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get credit number of course
	 * @return credit number of course
	 */
	public int getCreditNum() {
		return creditNum;
	}
	
	/**
	 * Add prereq of course
	 * @param prereq of course
	 */
	public void addPrereq(Course prereq) {
		this.prereqList.add(prereq);
	}
	
	/**
	 * Get prereqs of course
	 * @return prereqs of course
	 */
	public ArrayList<Course> getPrereq() {
		return prereqList;
	}
	
	/**
	 * Print contents of all fields of course
	 */
	@Override
	public String toString() {	
		StringBuilder str = new StringBuilder();
		if(!prereqList.isEmpty()) {
			for(int i = 0; i < prereqList.size(); i++) {
				str.append(prereqList.get(i).getCode() + ""
			+ prereqList.get(i).getCourseNum() + " ");
			}
		}	
		return String.format("%-5s %-9d %-44s %-9d %-10s", code.toString(), 
				courseNum, name, creditNum, str.toString());
	}

	private SubjectCode code;
	private int courseNum;
	private String name;
	private int creditNum;
	private ArrayList<Course> prereqList;
}

