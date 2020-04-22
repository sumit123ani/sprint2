package com.cg.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Question;
import com.cg.entity.Test;
import com.cg.entity.User;

@Repository
@Transactional
public class OnlineTestDaoImpl implements OnlineTestDaoI {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public void createUser(User user) {
		manager.persist(user);
	}

	@Override
	public void createTest(Test test) {
	  manager.persist(test);
	}

	@Override
	public void createQuestion(Question question) {
		manager.persist(question);
	}

	@Override
	public List<Test> getAllTest() {
		Query query = manager.createQuery("from Test t");
		return query.getResultList();
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		User user1 = manager.find(User.class, user.getUserId());
		if(user1 != null)
		{
			
			user1.setUserName(user.getUserName());
			user1.setUserPassword(user.getUserPassword());
			user1.setIsAdmin(user.getIsAdmin());
			
			return "user updated succesfully";
		}
		else
		{
			return "user not found";
		}
	}

	@Override
	public User getUser(BigInteger id) {
		User user1 = manager.find(User.class, id);
		return user1;
	}

       @Override
	public List<Question> getQuestionList(BigInteger testId) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("from Question que where test_fk ="+testId);
		return query.getResultList();
	}
}
