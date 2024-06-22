package com.sunbeam.services;

import java.util.Optional;

import com.sunbeam.entities.User;

public interface UserService {
	public Optional<User> Login(String email, String Password);
}
