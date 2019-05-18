/*
 * Zachary Bax
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package registration;

import enums.Building;
import enums.Quarter;
import person.Faculty;

/**
 * The Section class holds information about a course section.
 * 
 * For example, CPSC 5011-01: Object-Oriented Concepts
 * - course: CPSC 5011
 * - section: 02
 * - instructor: Sheila Oh
 * - quarter/year: FQ18
 * - capacity: 30
 * - building/room: LEML 122
 * 
 * @author zacharybax
 */
public class Section {	
	
	/**
	 * Constructor for Section initializing course, section, instructor, 
	 * quarter, year, cap, bldg and room.
	 * @param course	 The course associated with the section
	 * @param section	 The section number for the course
	 * @param instructor The faculty instructor teaching the course
	 * @param quarter	 The quarter that the course section is held 
	 * @param year		 The year that the course section is held
	 * @param cap		 The capacity of the course section
	 * @param bldg		 The building that the course section is held
	 * @param room		 The room that the course section is held
	 */
	public Section(Course course, int section, Faculty instructor, Quarter quarter, 
					int year, int cap, Building bldg, int room) {
		this.course = course;
		this.section = section;
		this.instructor = instructor;
		this.quarter = quarter;
		this.year = year;
		this.cap = cap;
		this.bldg = bldg;
		this.room = room;
	}

	/**
	 * Get course of section
	 * @return course of section
	 */
	public Course getCourse() {
		return course;
	}
	
	/**
	 * Get section number of section
	 * @return section number
	 */
	public int getSection() {
		return section;
	}
	
	/**
	 * Get instructor of section
	 * @return instructor of section
	 */
	public Faculty getInstructor() {
		return instructor;
	}
	
	/**
	 * Get quarter of section
	 * @return quarter of section
	 */
	public Quarter getQuarter() {
		return quarter;
	}
	
	/**
	 * Get year of section
	 * @return year of section
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Get capacity of section
	 * @return cap of section
	 */
	public int getCap() {
		return cap;
	}
	
	/**
	 * Get building of section
	 * @return bldg of section
	 */
	public Building getBldg() {
		return bldg;
	}
	
	/**
	 * Get room of section
	 * @return room of section
	 */
	public int getRoom() {
		return room;
	}
	
	/**
	 * Print contents of all fields of section
	 */
	@Override
	public String toString() {
		return String.format("%-5s %-10d %-8d %-15s %-1s %-5d %-8d %-8s %-5d", 
				course.getCode().toString(), course.getCourseNum(), section, 
				(instructor.getFirstName() + " " + instructor.getLastName()), 
				quarter.toString(), year, cap, bldg.toString(), room);
	}

	private Course course;
	private int section;
	private Faculty instructor;
	private Quarter quarter;
	private int year;
	private int cap;
	private Building bldg;
	private int room;
}
