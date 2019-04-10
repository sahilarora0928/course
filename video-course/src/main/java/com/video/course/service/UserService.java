package com.video.course.service;

import java.util.Optional;

import com.video.course.entity.User;

public interface UserService {
	Optional<User> fetchUser(String userId);
	
	byte[] fetchUserImage(String userId);
}
