package com.komodo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komodo.school.model.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{

}
