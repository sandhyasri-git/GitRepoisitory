package com.niit.backend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Model.User;

@Repository(value = "userDAO")
@EnableTransactionManagement

public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	public boolean isValidate(int id, String password) {
		String hql = "from User where id=" + id + " and " + " name =" + password;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		Session s= sessionFactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(user);
		tx.commit();

	}

	public User get(String email) {
		String hql = "From user where email='" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = (List<User>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<User> list() {

		List<User> list = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void delete(String email) {
		User user = new User();

		sessionFactory.getCurrentSession().delete(email);

	}

}
