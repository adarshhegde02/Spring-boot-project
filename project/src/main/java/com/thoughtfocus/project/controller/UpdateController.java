package com.thoughtfocus.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.project.dto.UpdateDobDTO;
import com.thoughtfocus.project.dto.UpdateGenderDTO;
import com.thoughtfocus.project.dto.UpdatePasswordDTO;
import com.thoughtfocus.project.service.UpdateService;

@RestController
public class UpdateController {
	@Autowired
	UpdateService updateService;

	@PostMapping("/fotgotPassword")
	String updatePassword(@RequestBody UpdatePasswordDTO dto) {
		if (dto != null) {
			if (dto.getEmail() != null && dto.getEmail() != "" && dto.getEmail().length() > 10
					&& dto.getEmail().length() < 20 && dto.getEmail().endsWith("@gmail.com")) {
				if (dto.getPassword() != null && dto.getPassword() != "") {
					return updateService.updatePassword(dto);
				} else {
					return "Password cannot be empty!";
				}
			} else {
				return "Enter a valid email Id!";
			}
		} else {
			return "Password not updated!";
		}
	}

	@PostMapping("/updateDOB")
	String updateDob(@RequestBody UpdateDobDTO dto) {
		if (dto != null) {
			if (dto.getDob() != null && dto.getDob() != "") {
				if (dto.getName() != null && dto.getName() != "") {
					return updateService.updateDob(dto);
				} else {
					return "Name cannot be empty!";
				}
			} else {
				return "DOB cannot be empty!";
			}
		} else {
			return "DOB not updated!";
		}
	}

	@PostMapping("/updateGender")
	String updateGender(@RequestBody UpdateGenderDTO dto) {
		if (dto != null) {
			if (dto.getGender().toLowerCase().equals("male") || dto.getGender().toLowerCase().equals("female")) {
				if (String.valueOf(dto.getContact()).length() == 10) {
					return updateService.updateGender(dto);
				} else {
					return "Please enter a 10 digit contact number";
				}
			} else {
				return "Please enter a valid gender type!";
			}
		} else {
			return "Gender not updated!";
		}
	}
}
