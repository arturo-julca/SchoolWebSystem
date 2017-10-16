package com.komodo.school.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.Evaluation;
import com.komodo.school.model.EvaluationResult;
import com.komodo.school.model.Student;
import com.komodo.school.repository.EvaluationRepository;
import com.komodo.school.repository.EvaluationResultRepository;
import com.komodo.school.repository.StudentRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class EvaluationResultHandler{

	@Autowired
	EvaluationResultRepository evaluationResultRepository;
	
	@Autowired
	EvaluationRepository evaluationRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public EvaluationResult save(EvaluationResult evaluationResult, Long idEvaluation, Long idStudent){
		Evaluation evaluation = evaluationRepository.getOne(idEvaluation);
		Student student = studentRepository.getOne(idStudent);
		evaluationResult.setEvaluation(evaluation);
		evaluationResult.setStudent(student);
		return evaluationResultRepository.saveAndFlush(evaluationResult);
	}
	
	public List<EvaluationResult> findAll(){
		return evaluationResultRepository.findAll();
	}
	
	public EvaluationResult findOne(Long idEvaluationResult){
		return evaluationResultRepository.findOne(idEvaluationResult);
	}
	
	public EvaluationResult update(Long idEvaluationResult, EvaluationResult evaluationResult){
		return (EvaluationResult) ControllerUtil.update(evaluationResultRepository, evaluationResult, idEvaluationResult);
	}
	
	public EvaluationResult delete(Long idEvaluationResult){
		return (EvaluationResult) ControllerUtil.delete(evaluationResultRepository, idEvaluationResult);
	}
}
