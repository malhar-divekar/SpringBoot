package com.app.malhar.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.malhar.bean.Student;
import com.app.malhar.exception.StudentNotFoundException;
import com.app.malhar.repo.StudentRepository;
import com.app.malhar.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;
	
	
	public Integer saveStudent(Student student) {
		Integer id=repo.save(student).getStdId();
		return id;
	}

	
	public List<Student> getAllStudents() {
		List<Student> list=repo.findAll();
		return list;
	}

	
	public Student getOneStudent(Integer Id) {
		return repo.findById(Id).orElseThrow(
				()-> new StudentNotFoundException("Student'"+Id+"'Not Exist")
				);
	
	}

	
	public void deleteStudent(Integer Id) {

		repo.delete(getOneStudent(Id));
	}

	
	public void updateStudent(Student student) {
		if(student.getStdId()==null || !repo.existsById(student.getStdId()))
			throw new StudentNotFoundException("Student"+student.getStdId()+" Not Exist");
		else
			repo.save(student);

	}

}
