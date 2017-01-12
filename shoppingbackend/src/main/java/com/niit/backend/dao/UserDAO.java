package com.niit.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.backend.Model.User;

@Repository
public interface UserDAO {
	public boolean isValidate(int id, String password);

	public void saveOrUpdate(User user);

	public void delete(String email);

	public User get(String email);

	public List<User> list();

}
