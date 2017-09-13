package com.material.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.material.domain.User;
import com.material.valid.LoginForm;

@Repository
@Transactional
public class UserDao extends BaseDao<User>{
	
	public void save(User user){
		try {
			getSession().save(user);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public User findById(String id) {
		try {
			User instance = getSession().get(User.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
		
	}
	
	public void merge(User user){
		try {
			getSession().merge(user);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public List<User> findByUser(LoginForm loginForm){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Property.forName("account").eq(loginForm.getAccount()));
		dc.add(Property.forName("password").eq(loginForm.getPassword()));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		return criteria.list();
	}
}
