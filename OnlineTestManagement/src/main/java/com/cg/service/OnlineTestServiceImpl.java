package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cg.dao.OnlineTestDaoI;
import com.cg.entity.Question;
import com.cg.entity.Result;
import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.exception.OnlineTestException;

@Service
public class OnlineTestServiceImpl implements OnlineTestServiceI {

	@Autowired
	OnlineTestDaoI dao;
	
	@Override
	public void createUser(User user) throws OnlineTestException{
		try {
	   dao.createUser(user);
	   }
		catch (DataIntegrityViolationException exception) {
		
			throw new OnlineTestException("id already is");
		}
	
	}

	@Override
	public void createTest(Test test) {
		try
		{
		dao.createTest(test);
		}
		catch(DataIntegrityViolationException exception)
		{
			throw new OnlineTestException("Test already exists");
		}
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
	public void updateQuestion(Question question) throws OnlineTestException {
		dao.updateQuestion(question);
		
	}

	@Override
	public void deleteQuestion(BigInteger questionId) {
		dao.deleteQuestion(questionId);
		
	}

	@Override
	public void updateTest(Test test) throws OnlineTestException {
		
		dao.updateTest(test);
	}

	@Override
	public void asignTest(Test test) throws OnlineTestException {

        dao.asignTest(test);
		
	}

	@Override
	public void deleteTest(int testId) {
	
	  dao.deleteTest(testId);	
	}

	@Override
	public void createResult(Result result) {
		
		dao.createResult(result);
	}

	@Override
	public void addQuestionTotTest(Test test) {

         dao.addQuestionToTest(test);
		
	}

	
}
