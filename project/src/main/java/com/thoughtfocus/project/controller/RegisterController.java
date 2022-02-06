package com.thoughtfocus.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.project.dto.RegisterDTO;
import com.thoughtfocus.project.service.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@PostMapping("/register")
	String register(@RequestBody RegisterDTO dto) {
		if (dto != null) {
			if (dto.getEmail() != null && dto.getEmail() != "" && dto.getEmail().length() > 10
					&& dto.getEmail().length() < 20 && dto.getEmail().endsWith("@gmail.com")) {
				if (String.valueOf(dto.getContact()).length() == 10) {
					if (dto.getPassword() != null && dto.getPassword() != "") {
						if (dto.getPassword().equals(dto.getConfirmPassword())) {
							if(dto.getName()!=null && dto.getName()!="") {
							return registerService.registerUser(dto);
							}else {
								return "Name cannot be empty";
							}
						} else {
							return "Please confirm your password...";
						}
					} else {
						return "Password cannot be empty!";
					}
				} else {
					return "Enter a 10 digit contact number!";
				}
			} else {
				return "Enter a valid email Id!";
			}
		} else {
			return "Not saved!";
		}
	}

}
