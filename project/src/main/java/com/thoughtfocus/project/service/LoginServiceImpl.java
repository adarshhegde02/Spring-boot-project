package com.thoughtfocus.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.entity.DetailsEntity;
import com.thoughtfocus.project.repository.DetailsRepo;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	DetailsRepo repo;

	@Override
	public DetailsEntity getDetails(String email, String password) {
		if (email != null && password != null) {
			return repo.getByEmailAndPassword(email, password);
		}
		return null;
	}

}
