package com.cg.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Question;
import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.service.OnlineTestServiceI;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class OnlineTestController {

	@Autowired
	OnlineTestServiceI service;
	
	@PostMapping(value="/user/new", consumes= {"application/json"})
	public String createUser(@RequestBody User user)
	{
		service.createUser(user);
		return "user created";
	}
	
	
	@PostMapping(value="/test/new", consumes= {"application/json"})
	public String createTest(@RequestBody Test test)
	{
		service.createTest(test);
		return "test created";
	}
	
	
	@PostMapping(value="/question/new", consumes= {"application/json"})
	public String createQuestion(@RequestBody Question question)
	{
		service.createQuestion(question);
		return "question created";
	}
	
	
	@PostMapping(value="/option/new", consumes= {"application/json"})
	public String createOption(@RequestBody OptionList option)
	{
		service.createOption(option);
		return "added";
	}

	
	@GetMapping(value="/test")
	public List<Test> getTestList()
	{
		return service.getAllTest();
	}
	
	
	@GetMapping(value="/user/{id}")
	public User getUser(@PathVariable BigInteger id)
	{
		return service.getUser(id);
	}

	
	@GetMapping(value = "/question/{testId}")
	public List<Question> getQuestionList(@PathVariable BigInteger testId)
	{
		return service.getQuestionList(testId);
	}
	
	
	@PutMapping(value="user/update",consumes= {"application/json"})
	public String updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}
}
