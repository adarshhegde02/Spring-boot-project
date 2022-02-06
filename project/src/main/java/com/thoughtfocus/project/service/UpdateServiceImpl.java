package com.thoughtfocus.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.dto.UpdateDobDTO;
import com.thoughtfocus.project.dto.UpdateGenderDTO;
import com.thoughtfocus.project.dto.UpdatePasswordDTO;
import com.thoughtfocus.project.entity.DetailsEntity;
import com.thoughtfocus.project.exception.InvalidEmailIdException;
import com.thoughtfocus.project.exception.NullObjectException;
import com.thoughtfocus.project.repository.DetailsRepo;

@Service
public class UpdateServiceImpl implements UpdateService {

	Logger logger = LoggerFactory.getLogger(UpdateServiceImpl.class);

	@Autowired
	DetailsRepo repo;

	@Override
	public String updatePassword(UpdatePasswordDTO dto) {
		DetailsEntity entity;
		try {
			if (dto.getEmail().length() > 10 && dto.getEmail().length() < 20) {
				entity = repo.getByEmail(dto.getEmail());
				System.out.println(entity);
				if (entity != null) {
					entity.setPassword(dto.getPassword());
					repo.save(entity);
					logger.info(entity.getName() + " updated");
					return entity.getName() + " Updated";
				} else {
					logger.error("Not updated");
					throw new NullObjectException("User not found");
				}
			} else {
				logger.error("Invalid email Id");
				throw new InvalidEmailIdException("Invlid email Id");

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error(e.getClass().getSimpleName());
		}
		return "Not updated";
	}

	@Override
	public String updateDob(UpdateDobDTO dto) {
		DetailsEntity entity = repo.getByName(dto.getName());
		if (entity != null) {
			entity.setDob(dto.getDob());
			repo.save(entity);
			return entity.getName() + " Updated";
		} else {
			return "Not updated";
		}
	}

	@Override
	public String updateGender(UpdateGenderDTO dto) {
		DetailsEntity entity = repo.getByContact(dto.getContact());
		if (entity != null) {
			entity.setGender(dto.getGender().toLowerCase());
			repo.save(entity);
			return entity.getName() + " Updated!";
		} else {
			return "Contact number is not present!";
		}
	}

}
