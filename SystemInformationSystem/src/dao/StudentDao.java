package dao;

import java.util.List;
import java.util.Map;

import model.Course;
import model.Student;

public interface StudentDao {
	void addNewStudent(Student student);
	void updateStudentProfile(Student student);
	Map<Student, Course> viewAllRegistrations();
	void registration(Student student, Course course);
	Student findStudentByRollNo(int rollNo);
	List<Student> viewAllStudents();
	String addNewCourse(Course course);
	List<Course> viewAllCourses();
	Course findCourseById(int courseId);
}


