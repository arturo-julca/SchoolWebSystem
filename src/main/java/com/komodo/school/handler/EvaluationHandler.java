package com.komodo.school.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.ClassEd;
import com.komodo.school.model.Evaluation;
import com.komodo.school.repository.ClassEdRepository;
import com.komodo.school.repository.EvaluationRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class EvaluationHandler{

	@Autowired
	EvaluationRepository evaluationRepository;
	
	@Autowired
	ClassEdRepository classRepository;
	
	public Evaluation save(Evaluation evaluation, Long idClass){
		ClassEd classEd = classRepository.getOne(idClass);
		evaluation.setClassEd(classEd);
		return evaluationRepository.saveAndFlush(evaluation);
	}
	
	public List<Evaluation> findAll(){
		return evaluationRepository.findAll();
	}
	
	public Evaluation findOne(Long idEvaluation){
		return evaluationRepository.findOne(idEvaluation);
	}
	
	public Evaluation update(Long idEvaluation, Evaluation evaluation){
		return (Evaluation) ControllerUtil.update(evaluationRepository, evaluation, idEvaluation);
	}
	
	public Evaluation delete(Long idEvaluation){
		return (Evaluation) ControllerUtil.delete(evaluationRepository, idEvaluation);
	}
}
