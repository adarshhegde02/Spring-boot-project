package com.thoughtfocus.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.dto.RegisterDTO;
import com.thoughtfocus.project.entity.DetailsEntity;
import com.thoughtfocus.project.exception.UserAlreadyExistsException;
import com.thoughtfocus.project.repository.DetailsRepo;

@Service
public class RegisterServiceImpl implements RegisterService {

	static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

	@Autowired
	DetailsRepo repo;

	@Override
	public String registerUser(RegisterDTO dto) {
		DetailsEntity detailsEntity = new DetailsEntity();
		logger.info(dto.toString());
		try {
			if (repo.getByEmail(dto.getEmail()) != null) {
				throw new UserAlreadyExistsException("User is already present");
			} else {
				BeanUtils.copyProperties(dto, detailsEntity);

				logger.info(detailsEntity.toString());
				repo.save(detailsEntity);
				logger.info(dto.getName() + " Saved");
				return dto.getName() + " Saved";

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error(e.getClass().getSimpleName());
		}
		logger.error(dto.getName() + " not saved");
		return "Not saved";
	}

}
