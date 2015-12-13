package com.hrd.app.services;

import java.util.ArrayList;

import com.hrd.app.entities.Student;

public interface StudentService {
	public boolean insertStudent(Student student);
	public boolean deleteStudent(int id);
	public boolean updateStudent(Student student);
	public ArrayList<Student> getAllStudents();
	public int getMaxID(String tablename);
}
