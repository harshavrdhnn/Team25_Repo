package controller;


import java.util.List;
import java.util.Map;

import Exception.PhoneException;
import dao.StudentDao;
import dao.StudentDaoImplDatabase;
import model.Course;
import model.Registration;
import model.Student;

public class StudentController {
	
	StudentDao dao=new StudentDaoImplDatabase();
	
	
	public String addNewStudent(Student student) {
		if(student.getPhoneNo().length()!=10) {
			
			
			try {
				throw new PhoneException("Invalid phone number");
			} catch (PhoneException e) {
				return e.getMessage();
			}
				
			
		}
		return dao.addNewStudent(student);
		//String message= dao.addNewStudent(student);
		//return message;
		
	}

	public void updateStudentProfile(Student student) {
		
	}

	public void registration(Student student, Course course) {
		
	}
	
	public String registrationDb(Student student,Course course) {
		String message="";
		Course registration;
		if(dao.findStudentByRollNo(registration.getCourseId()));
		return "";
	}

	
	public Map<Student, Course> viewAllRegistrations() {
		
		return null;
	}


	public Student findStudentByRollNo(int rollNo) {
		
		return dao.findStudentByRollNo(rollNo);
	}


	public List<Student> viewAllStudents() {
		
		return dao.viewAllStudents();
	}

	public String addNewCourse(Course course) {
		return "";
	
	}

	public Course findCourseById(int courseId) {
	
		return dao.findCourseById(courseId);
	}

	
	public List<Course> viewAllCourses() {
	
		return dao.viewAllCourses();
	}

	public String registrationDb(Registration registration) {
		// TODO Auto-generated method stub
		return null;
	}

}
