package com.niit.dao;

import java.util.List;

import com.niit.model.UserDetails;

public interface UserDetailsDAO {
	public boolean addUser(UserDetails userDetails);
	public boolean updateUser(UserDetails userDetails);
	public boolean deleteUser(UserDetails userDetails);
	public boolean approveUser(UserDetails userDetails);
	public UserDetails getUser(String userName);
	public List<UserDetails> listUsers();
}
