package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.entity.Question;
import com.cg.entity.Test;
import com.cg.entity.User;

public interface OnlineTestServiceI {


	public void createUser(User user);
	public void createTest(Test test);
	public void createQuestion(Question question);

    public String updateUser(User user);	
	
	public User getUser(BigInteger id);
	public List<Test> getAllTest();
        public List<Question> getQuestionList(BigInteger testId);
}
