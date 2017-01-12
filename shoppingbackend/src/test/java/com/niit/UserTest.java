package com.niit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Model.User;
import com.niit.backend.dao.UserDAO;

public class UserTest {
	
	static AnnotationConfigApplicationContext context;


	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		UserDAO userDAO=(UserDAO)context.getBean("userDAO");
		User user=(User)context.getBean("user");
		user.setUsername("s001");
		user.setPassword("1234");
		user.setCpassword("1234");
		user.setEmail("ss@yahoo.com");
		user.setPhno("12345678");
		user.setEnabled("true");
		userDAO.saveOrUpdate(user);


	}

}
