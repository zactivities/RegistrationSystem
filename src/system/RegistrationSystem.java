/*
 * Zachary Bax
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package system;

import java.util.HashMap;

import enums.Building;
import enums.FacultyType;
import enums.Quarter;
import enums.StudentType;
import enums.SubjectCode;
import enums.StudentProgram;
import exception.CourseNotFoundException;
import exception.DuplicateCourseException;
import exception.DuplicatePersonException;
import exception.DuplicateSubjectException;
import exception.PersonNotFoundException;
import exception.DuplicateSectionException;
import person.Faculty;
import person.Student;
import person.UndergradStudent;
import registration.Course;
import registration.Section;

/**
 * The RegistrationSystem class stores information about the school, including
 * the ability to add students, add faculty, add courses, and add prerequisite(s).
 * 
 * @author zacharybax
 */
public class RegistrationSystem {
	
	/**
	 * Constructor for registration system to initialize data structures.
	 */
	public RegistrationSystem() { 
		this.facultyList = new HashMap<>();
		this.studentList = new HashMap<>();
		this.courseList = new HashMap<>();
		this.sectionList = new HashMap<>();
		this.subjectList = new HashMap<>();
	}
	
	/**
	 * Add a student to the student list collection.
	 * 
	 * @param firstName	The first name of the student
	 * @param lastName	The last name of the student
	 * @param type		The student type
	 * @param program	The student program	
	 * @param quarter	The start quarter of the student
	 * @param year		The start year of the student
	 * @throws DuplicatePersonException The person is already in the system
	 */
	public void addStudent(String firstName, String lastName, 
							StudentType type, StudentProgram program,
							Quarter quarter, int year) 
							throws DuplicatePersonException {
		
		if(studentList.containsKey(firstName+lastName)) {
			throw new DuplicatePersonException();
		} 
		else if(type.equals(StudentType.UNDERGRAD)){
			UndergradStudent undergrad = new UndergradStudent(firstName, 
					lastName);
			undergrad.setType(type);
			undergrad.setProgram(program);
			undergrad.setStartQuarter(quarter);
			undergrad.setYear(year);
			studentList.put(firstName+lastName, undergrad);
		} 
		else {
			Student student = new Student(firstName, lastName);
			student.setType(type);
			student.setProgram(program);
			student.setStartQuarter(quarter);
			student.setYear(year);
			studentList.put(firstName+lastName, student);
		}
	}
	
	/**
	 * Add a faculty to the faculty list collection.
	 * 
	 * @param firstName	The first name of the faculty
	 * @param lastName	The last name of the faculty
	 * @param type		The faculty type
	 * @param bldg		The building of the faculty office
	 * @param room		The (building) room of the faculty office
	 * @param email		The email of the faculty
	 * @throws DuplicatePersonException The person is already in the system
	 */
	public void addFaculty(String firstName, String lastName,
							FacultyType type, Building bldg, int room, String email) 
							throws DuplicatePersonException {	
		if(facultyList.containsKey(firstName+lastName)) {
			throw new DuplicatePersonException();
		} 
		else {
			Faculty prof = new Faculty(firstName, lastName, email);
			prof.setType(type);
			prof.setBuidling(bldg);
			prof.setRoom(room);
			facultyList.put(firstName+lastName, prof);
		}
	}
	
	/**
	 * Adds a subject to the subject list collection.
	 * 
	 * @param code	The subject code
	 * @param desc	The subject description
	 * 
	 * @throws DuplicateSubjectException The subject is already in the system
	 */
	public void addSubject(SubjectCode code, String desc) 
			throws DuplicateSubjectException {
		if(subjectList.containsKey(code.toString())) {
			throw new DuplicateSubjectException();
		}
		else {
			subjectList.put(code.toString(), desc);
		}		
	}
	
	/**
	 * Adds a course to the course list collection.
	 * 
	 * @param code		The subject code of the course
	 * @param num		The course number of the course
	 * @param name		The course name
	 * @param creditNum	The number of the credits of the course
	 * @throws DuplicateCourseException	The course is already in the system 
	 */
	public void addCourse(SubjectCode code, int num, String name, 
							int creditNum) throws DuplicateCourseException {
	
		String key = (code.toString() + Integer.toString(num));
		if(courseList.containsKey(key)) {
			throw new DuplicateCourseException();
		}
		else {
			Course course = new Course(code, num, name, creditNum);
			courseList.put(key, course);
		}
	}
	
	/**
	 * Adds a prerequisite to an existing course in the course
	 * list collection.
	 * 
	 * @param code			The subject code of the course
	 * @param num			The course number of the course
	 * @param prereqCode	The subject code of the prerequisite
	 * 						to add to the course
	 * @param prereqNum		The course number of the prerequisite
	 * 						to add to the course
	 * @throws CourseNotFoundException The course was not found in the system
	 */
	public void addPrerequisite(SubjectCode code, int num, 
							SubjectCode prereqCode, int prereqNum) 
							throws CourseNotFoundException {
		String courseKey = (code.toString() + Integer.toString(num));
		String prereqKey = (prereqCode.toString() 
				+ Integer.toString(prereqNum));

		if(!courseList.containsKey(courseKey)) {
			throw new CourseNotFoundException();
		}
		else if(!courseList.containsKey(prereqKey)) {
			throw new CourseNotFoundException();
		}		
		else {
			Course prereq = courseList.get(prereqKey);
			courseList.get(courseKey).addPrereq(prereq);
		}
	}
	
	/**
	 * Adds a section to the section list collection.
	 * 
	 * @param code		 The subject code of the course
	 * @param courseNum	 The course number of the course
	 * @param sectionNum The section number for the course
	 * @param firstName	 The first name for the faculty teaching the course
	 * @param lastName	 The last name for the faculty teaching the course
	 * @param quarter	 The quarter that the course section is held 
	 * @param year		 The year that the course section is held
	 * @param cap		 The capacity of the course section
	 * @param bldg		 The building that the course section is held
	 * @param room		 The room that the course section is held
	 * @throws CourseNotFoundException The course was not found in the system
	 * @throws PersonNotFoundException The person was not found in the system
	 * @throws DuplicateSectionException The section is already in the system
	 */
	public void addSection(SubjectCode code, int courseNum, int sectionNum,
							String firstName, String lastName, Quarter quarter, int year, 
							int cap, Building bldg, int room) 
							throws CourseNotFoundException, 
							PersonNotFoundException, DuplicateSectionException {

		String courseKey = (code.toString() + Integer.toString(courseNum));
		String sectionKey = (code.toString() + Integer.toString(courseNum) + 
				Integer.toString(sectionNum));
		
		if(!courseList.containsKey(courseKey)) {
			throw new CourseNotFoundException();
		}
		else if(!facultyList.containsKey(firstName+lastName)) {
			throw new PersonNotFoundException();
		}
		else if(sectionList.containsKey(sectionKey)) {
			throw new DuplicateSectionException();
		}
		else {
			Course course = courseList.get(courseKey);
			Faculty faculty = facultyList.get(firstName+lastName);
			Section section = new Section(course, sectionNum, faculty, quarter, 
					year, cap, bldg, room);
			sectionList.put(sectionKey, section);
		}
	}
	
	/**
	 * Print content from all lists. 
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\t\t  STUDENT LIST\n\n");
		str.append("ID  FIRST NAME   LAST NAME  TYPE        "
				+ "      PROGRAM    QUARTER  YEAR     EMAIL\n");
		str.append("-----------------------------------------"
				+ "--------------------------------------------------------\n");
		for (String student : this.studentList.keySet()) {
			String key = student.toString();
            Student value = studentList.get(key);
            str.append(value + "\n");  
		}
		
		str.append("\n\t\t  FACULTY LIST\n\n");
		str.append("ID  FIRST NAME   LAST NAME  TYPE       "
				+ "       BUILDING   ROOM     EMAIL\n");
		str.append("---------------------------------------------------------"
				+ "---------------------------------\n");
		for (String faculty : this.facultyList.keySet()) {
			String key = faculty.toString();
            Faculty value = facultyList.get(key);
            str.append(value + "\n");  
		}
		
		str.append("\n\t\t  SUBJECT LIST\n\n");
		str.append("SUBJECTS\n");
		str.append("----------------\n");
		for (String code : this.subjectList.keySet()) {
			String key = code.toString();
            String value = subjectList.get(key);
            str.append(value + "\n");  
		}
		
		str.append("\n\t\t  COURSE LIST\n\n");
		str.append("CODE  COURSE #  NAME                                 "
				+ "        CREDITS   PREREQ\n");
		str.append("-----------------------------------------------"
				+ "-----------------------------------------\n");
		for (String course : this.courseList.keySet()) {
			String key = course.toString();
            Course value = courseList.get(key);
            str.append(value + "\n");  
		}
		
		str.append("\n\t\t  SECTION LIST\n\n");
		str.append("CODE  COURSE #   SECTION  INSTRUCTOR      QUARTER  "
				+ "CAPACITY BUILDING ROOM\n");
		str.append("-----------------------------------------------"
				+ "--------------------------\n");
		for (String section : this.sectionList.keySet()) {
			String key = section.toString();
            Section value = sectionList.get(key);
            str.append(value + "\n");  
		}
		
		return str.toString();
	}
	
	private HashMap<String, Faculty> facultyList;
	private HashMap<String, Student> studentList;
	private HashMap<String, Course> courseList;
	private HashMap<String, Section> sectionList;
	private HashMap<String, String> subjectList;
}
