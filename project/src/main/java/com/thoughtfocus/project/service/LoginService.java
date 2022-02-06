package com.thoughtfocus.project.service;

import com.thoughtfocus.project.entity.DetailsEntity;

public interface LoginService {
	public DetailsEntity getDetails(String email, String password);
}
