package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.service.OnlineTestServiceI;


@SpringBootApplication
public class OnlineTestManagementApplication {

	@Autowired
	OnlineTestServiceI service;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineTestManagementApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		Test test = new Test(107, "java", "02:00:00", 20, 0, "09:00:00", "11:00:00");
////		service.createTest(test);
//		
//		User user = new User();
//		user.setUserId(100);
//		user.setUserName("sumit");
//		user.setUserPassword("1234");
//		user.setAdmin("true");
//		user.setUserTest(test);
//		service.createUser(user);
//	}

}
