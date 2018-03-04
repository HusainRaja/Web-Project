package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetails;

public class UserDetailsDAOImpl implements UserDetailsDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(userDetails);
			return true;
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}

	@Transactional
	public boolean updateUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean approveUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		try {
			//userDetails.setEnabled(true);
			//System.out.println(userDetails.getEnabled());
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public UserDetails getUser(String userName) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		UserDetails user=session.get(UserDetails.class, userName);
		return user;
	}

	
	public List<UserDetails> listUsers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetails");
		List<UserDetails> list=(List<UserDetails>)query.list();
		return list;
	}

}
