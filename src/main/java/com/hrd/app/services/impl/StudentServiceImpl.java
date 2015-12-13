package com.hrd.app.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrd.app.entities.Student;
import com.hrd.app.services.StudentService;

@Repository
public class StudentServiceImpl implements StudentService{

	private Connection con = null;
	
	@Autowired
	private DataSource dataSource = null;
	
	// Injection via constructor
	/*public StudentServiceImpl(DataSource dataSource){
		this.dataSource = dataSource;
	}*/
	
	// Injection via setter
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public boolean insertStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Student> getAllStudents() {
		String sql = "SELECT id, firstname, lastname, gender FROM tblstudent ORDER BY id";
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			con = dataSource.getConnection();
			PreparedStatement ppst = con.prepareStatement(sql);
			ResultSet rs = ppst.executeQuery();
			Student student;
			while(rs.next()){
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setFirst_name(rs.getString("firstname"));
				student.setLast_name(rs.getString("lastname"));
				student.setGender(rs.getInt("gender"));
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getMaxID(String tablename) {
		// TODO Auto-generated method stub
		return 0;
	}

}
