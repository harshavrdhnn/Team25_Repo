package dao;

import java.sql.Connection;import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import connection.OracleConnection;
import model.Course;
import model.Qualification;
import model.Registration;
import model.Student;

public class StudentDaoImplDatabase implements StudentDao {
	
	Connection conn;
	PreparedStatement ps;
	
	public StudentDaoImplDatabase() {
		conn=OracleConnection.getConnection();
	}
	
	@Override
	public void addNewStudent(Student student) {
		String sql="insert into tbl_students values(seq_stud.nextval,?,?,?,?,?,?)";
		String message="";
		int count=0;
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, student.getName());
			ps.setDate(2, Date.valueOf(student.getDateOfBirth()));
			ps.setString(3, student.getQualification().name());
			ps.setString(4, student.getPhoneNo());
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getAddress());
			
			count=ps.executeUpdate();
			if(count>0) {
				message="New Student added Successfully";
			}else {
				message="Error Occured";
			}
			
			} catch (SQLException e) {
					// TODO Auto-generated catch block
			     e.printStackTrace();
			}
			return;	

	}

	@Override
	public void updateStudentProfile(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registration(Student student, Course course) {
		// TODO Auto-generated method stub
	}
	
	public String registrationDb(Registration registraion) {
		return null;
				
	}

	@Override
	public Map<Student, Course> viewAllRegistrations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {
		String sql="select * from tbl_students where rollNo=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, rollNo);
			
			ResultSet rs=ps.executeQuery();
			Student st=null;
			if(rs.next()) {
				st=new Student();
				st.setRollNo(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setDateOfBirth(rs.getDate(3).toLocalDate());
				st.setQualification(Qualification.valueOf(rs.getString(4)));
				st.setPhoneNo(rs.getString(5));
				st.setEmail(rs.getString(6));
				st.setAddress(rs.getString(7));
			}
			return st;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Student> viewAllStudents() {
		List<Student> students=new ArrayList<Student>();
		String sql="select * from tbl_students";
		ResultSet rs=null;
		
		try {
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			Student st=new Student();
			
			while(rs.next()) {
				st=new Student();
				st.setRollNo(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setDateOfBirth(rs.getDate(3).toLocalDate());
				st.setQualification(Qualification.valueOf(rs.getString(4)));
				st.setPhoneNo(rs.getString(5));
				st.setEmail(rs.getString(6));
				st.setAddress(rs.getString(7));
				students.add(st);
			}
			return students;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addNewCourse(Course course) {
		String sql="insert into tbl_courses values(seq_crs.nextval,?,?,?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getDurationInMonths());
			ps.setDouble(3, course.getFee());
			ps.setString(4, course.getEligibility().name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Course findCourseById(int courseId) {
		String sql="select * from tbl_courses where courseid=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, courseId);
			
			ps=(PreparedStatement) ps.executeQuery();
			Course course=null;
			if(((ResultSet) ps).next()) {
				course.setCourseId(((ResultSet) ps).getInt(1));
				//course.ps
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

}
