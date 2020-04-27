package com.cg.dao;

import java.math.BigInteger;
import java.util.List;

import com.cg.entity.Question;
import com.cg.entity.Test;
import com.cg.entity.User;

public interface OnlineTestDaoI {

	public void createUser(User user);
	public void createTest(Test test);
	public void createQuestion(Question question);

	
	public String updateUser(User user);
	public void updateQuestion(Question question);
	
	public User getUser(BigInteger id);
	public List<Test> getAllTest();
	public Test getTest(BigInteger id);
	
	public List<Question> getQuestionList(BigInteger testId);
	public List<Question> getAllQuestion();
	public Question getOneQuestion(BigInteger questionId);
	
	public void deleteQuestion(BigInteger questionId);
	
}
