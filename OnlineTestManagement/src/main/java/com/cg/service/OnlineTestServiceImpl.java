package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.OnlineTestDaoI;
import com.cg.entity.Question;
import com.cg.entity.Test;
import com.cg.entity.User;

@Service
public class OnlineTestServiceImpl implements OnlineTestServiceI {

	@Autowired
	OnlineTestDaoI dao;
	
	@Override
	public void createUser(User user) {
	   dao.createUser(user);
	
	}

	@Override
	public void createTest(Test test) {
		dao.createTest(test);
	}

	@Override
	public void createQuestion(Question question) {
		dao.createQuestion(question);
	}

	@Override
	public List<Test> getAllTest() {
		// TODO Auto-generated method stub
		return dao.getAllTest();
	}

	@Override
	public User getUser(BigInteger id) {
		// TODO Auto-generated method stub
		return dao.getUser(id);
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	

	@Override
	public List<Question> getQuestionList(BigInteger testId) {
		
		return dao.getQuestionList(testId);
	}

	@Override
	public List<Question> getAllQuestion() {
		
		return dao.getAllQuestion();
	}

	@Override
	public Question getOneQuestion(BigInteger questionId) {
		
		return dao.getOneQuestion(questionId);
	}

	@Override
	public void updateQuestion(Question question) {
		dao.updateQuestion(question);
		
	}

	@Override
	public void deleteQuestion(BigInteger questionId) {
		dao.deleteQuestion(questionId);
		
	}

	
}
