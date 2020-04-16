package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="optionList")
public class OptionList {

	@Id
	private int optionId;
	
	@Column
	private String option1;
	
	@Column
	private String option2;
	
	@Column
	private String option3;
	
	@Column
	private String option4;

	public OptionList(int questionId, String option1, String option2, String option3, String option4) {
		super();
		this.optionId = questionId;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}

	public int getQuestionId() {
		return optionId;
	}

	public void setQuestionId(int questionId) {
		this.optionId = questionId;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}
	
	
	
}
