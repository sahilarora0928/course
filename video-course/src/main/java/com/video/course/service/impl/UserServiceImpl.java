package com.video.course.service.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.video.course.entity.User;
import com.video.course.repository.UserRepository;
import com.video.course.service.UserService;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public Optional<User> fetchUser(String userId) {
		return userRepo.findById(Long.parseLong(userId));
	}

	@Override
	public byte[] fetchUserImage(String userId) {
		Optional<User> imagePath = userRepo.findById(Long.parseLong(userId));
		InputStream in = null;
		byte[] contents = null;
		try {
			in = new FileInputStream(imagePath.get().getUserImageFilePath());
			return IOUtils.toByteArray(in);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
