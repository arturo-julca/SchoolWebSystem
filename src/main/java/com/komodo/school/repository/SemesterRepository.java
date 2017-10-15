package com.komodo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komodo.school.model.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long>{

}
