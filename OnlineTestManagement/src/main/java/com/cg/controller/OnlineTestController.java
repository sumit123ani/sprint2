package com.cg.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entity.Question;
import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.exception.OnlineTestException;
import com.cg.service.OnlineTestServiceI;

@CrossOrigin
@RestController
public class OnlineTestController {

	@Autowired
	OnlineTestServiceI service;
	
	
	@PostMapping(value="/user/new", consumes= {"application/json"})
	public String createUser(@RequestBody User user, BindingResult bindingResult) throws OnlineTestException 
	{
		 String err ="";
		
		 if(bindingResult.hasErrors())
		 {
			 List<FieldError> errors = bindingResult.getFieldErrors();
			 for(FieldError error:errors)
			 {
				 err += error.getDefaultMessage() + "<br/>";
			 }
			 throw new OnlineTestException(err);
		 }
		 
		 try
		 {
			 service.createUser(user);
			 return "user created";
		 }
		 catch (DataIntegrityViolationException exception) {

              throw new OnlineTestException("ID already exists");
		}
	}
	
	
	@PostMapping(value="/test/new", consumes= {"application/json"})
	public String createTest(@RequestBody Test test)
	{
		service.createTest(test);
		return "test created";
	}
	
	
//	@PostMapping(value="/question/new", consumes= {"application/json"})
//	public String createQuestion(@RequestBody Question question)
//	{
//		service.createQuestion(question);
//		return "question created";
//	}

	
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

	
	@GetMapping(value = "/question/list/{testId}")
	public List<Question> getQuestionList(@PathVariable BigInteger testId)
	{
		return service.getQuestionList(testId);
	}
	
	@GetMapping(value = "/question")
	public List<Question> getAllQuestion()
	{
		return service.getAllQuestion();
	}
	
	
	@GetMapping(value = "/question/{questionId}")
	public Question getOneQuestion(@PathVariable BigInteger questionId)
	{
		return service.getOneQuestion(questionId);
	}
	
	@PutMapping(value="user/update",consumes= {"application/json"})
	public String updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}
	
	
	@PutMapping(value ="question/update", consumes= {"application/json"})
	public String updateQuestion(@RequestBody Question question)
	{
		service.updateQuestion(question);
		return "question updated";
	}
	
	
	@PutMapping(value = "test/update", consumes = {"application/json"})
	public String updateTest(@RequestBody Test test) throws OnlineTestException
	{
		service.updateTest(test);
		return "updated successfully";
	}
	
	
	@PutMapping(value = "assign/test", consumes = {"application/json"})
	public String assignTest(@RequestBody Test test)
	{
		service.asignTest(test);
		return "test assigned";
	}
	
	@DeleteMapping(value = "question/delete/{questionId}")
	public String deleteQuestion(@PathVariable BigInteger questionId)
	{
		service.deleteQuestion(questionId);
		return "deleted";
	}
	
	
	@DeleteMapping(value ="test/delete/{testId}")
	public String deleteTest(@PathVariable int testId)
	{
		service.deleteTest(testId);
		return "deletetd successfully"	;
		}
}

