package com.komodo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komodo.school.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
