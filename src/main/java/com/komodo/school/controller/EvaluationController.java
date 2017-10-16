package com.komodo.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.handler.EvaluationHandler;
import com.komodo.school.model.Evaluation;

@RestController
@RequestMapping("api/v1/evaluation")
public class EvaluationController {

	@Autowired
	EvaluationHandler evaluationHandler;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Evaluation> list(){
		return evaluationHandler.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Evaluation create(@RequestBody Evaluation evaluation, @RequestBody Long idClass){
		return evaluationHandler.save(evaluation, idClass);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Evaluation get(@PathVariable Long id){
		return evaluationHandler.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Evaluation update(@PathVariable Long id, @RequestBody Evaluation evaluation){
		return evaluationHandler.update(id, evaluation);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Evaluation delete(@PathVariable Long id){
		return evaluationHandler.delete(id);
	}

}
