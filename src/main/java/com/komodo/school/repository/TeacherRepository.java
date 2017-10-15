package com.komodo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komodo.school.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
