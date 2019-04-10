package com.video.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.video.course.service.UserService;

@Controller
@RequestMapping("/v1/course/")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<?> findUser(@PathVariable("userId") String userId) {
		return new ResponseEntity(userService.fetchUser(userId).get(), HttpStatus.OK);
	}

	@GetMapping(value = "/user/{userId}/image", produces = { "image/jpg", "image/jpeg", "image/png" })
	public ResponseEntity<?> fetchUserImage(@PathVariable("userId") String userId) {
		byte[] contents = userService.fetchUserImage(userId);
		return new ResponseEntity<>(contents, HttpStatus.OK);
	}
}
