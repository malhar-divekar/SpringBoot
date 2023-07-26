package com.app.malhar.service;

import java.util.List;

import com.app.malhar.bean.Student;

public interface IStudentService {
	
	Integer saveStudent (Student student);
	List<Student> getAllStudents();
	Student getOneStudent(Integer Id);
	void deleteStudent(Integer Id);
	void updateStudent(Student student);
}
