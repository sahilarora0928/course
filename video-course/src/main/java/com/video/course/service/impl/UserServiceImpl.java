package com.video.course.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.video.course.entity.User;
import com.video.course.repository.UserRepository;
import com.video.course.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public Optional<User> fetchUser(String userId) {
		return userRepo.findById(Long.parseLong(userId));
	}

}
