package com.cg.entity;

import java.io.Serializable;
import java.math.*;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question implements Serializable{

	@Id
	private BigInteger questionId ; 

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="optionId")
    private OptionList option;
	
	@Column
	private String questionTitle ;
	
	@Column
	private Integer questionAnswer ;
	
	@Column
	private BigDecimal questionMarks ;
	
	@Column
	private Integer chosenAnswer ;
	
	@Column
	private BigDecimal marksScored ; 

	
	public Question()
	{
		
	}


	public Question(BigInteger questionId, String questionTitle,
			Integer questionAnswer, BigDecimal questionMarks, Integer chosenAnswer, BigDecimal marksScored) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	}


	public BigInteger getQuestionId() {
		return questionId;
	}


	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}


	public String getQuestionTitle() {
		return questionTitle;
	}


	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}


	public Integer getQuestionAnswer() {
		return questionAnswer;
	}


	public void setQuestionAnswer(Integer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}


	public BigDecimal getQuestionMarks() {
		return questionMarks;
	}


	public void setQuestionMarks(BigDecimal questionMarks) {
		this.questionMarks = questionMarks;
	}


	public Integer getChosenAnswer() {
		return chosenAnswer;
	}


        public OptionList getOption() {
		return option;
	}


	public void setOption(OptionList option) {
		this.option = option;
	}

	public void setChosenAnswer(Integer chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}


	public BigDecimal getMarksScored() {
		return marksScored;
	}


	public void setMarksScored(BigDecimal marksScored) {
		this.marksScored = marksScored;
	}


	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionTitle="
				+ questionTitle + ", questionAnswer=" + questionAnswer + ", questionMarks=" + questionMarks
				+ ", chosenAnswer=" + chosenAnswer + ", marksScored=" + marksScored + "]";
	}
	
	
	
}
