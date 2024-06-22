package com.sunbeam.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunbeam.dao.UserDao;
import com.sunbeam.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
//  make a depn
	@Autowired
	private UserDao userDao;

	public UserServiceImpl() {
		System.out.println("inside UserService");
		// TODO Auto-generated constructor stub
		System.out.println("inside the UserDao Constrcutor");
	};

	@Override
	// login method
	public Optional<User> Login(String email, String Password) {
		System.out.println("Inside the LoginUserService!");
		Optional<User> user = userDao.findByEmailAndPassword(email, Password);
		return user;
	}

}
