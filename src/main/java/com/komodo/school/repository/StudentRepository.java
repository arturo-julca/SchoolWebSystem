package com.komodo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komodo.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
