package com.komodo.school.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evaluation{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int typeEvaluation;
	private int weight;
	
//	@OneToMany(mappedBy = "evaluationResult")
//	private List<EvaluationResult> listEvaluationResult;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "idclassEd")
	private ClassEd classEd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTypeEvaluation() {
		return typeEvaluation;
	}

	public void setTypeEvaluation(int typeEvaluation) {
		this.typeEvaluation = typeEvaluation;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

//	public List<EvaluationResult> getListEvaluationResult() {
//		return listEvaluationResult;
//	}
//
//	public void setListEvaluationResult(List<EvaluationResult> listEvaluationResult) {
//		this.listEvaluationResult = listEvaluationResult;
//	}

	public ClassEd getClassEd() {
		return classEd;
	}

	public void setClassEd(ClassEd classEd) {
		this.classEd = classEd;
	}

}
