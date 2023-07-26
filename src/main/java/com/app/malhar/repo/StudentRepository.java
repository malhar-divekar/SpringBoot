package com.app.malhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.malhar.bean.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
