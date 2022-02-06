package com.thoughtfocus.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.project.entity.DetailsEntity;
import com.thoughtfocus.project.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/login")
	String login(@RequestParam String email, @RequestParam String password) {
		DetailsEntity entity = new DetailsEntity();
		if (email != null && email != "" && email.length() > 10 && email.length() < 20
				&& email.endsWith("@gmail.com")) {
			if (password != null && password != "") {
				entity = loginService.getDetails(email, password);
				if (entity != null) {
					return "Logged in succesfully!";
				} else {
					return "Login failed";
				}
			} else {
				return "Enter a valid password!";
			}
		} else {
			return "Enter a valid email Id";
		}
	}

}
