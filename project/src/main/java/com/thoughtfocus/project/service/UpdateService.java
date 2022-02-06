package com.thoughtfocus.project.service;

import com.thoughtfocus.project.dto.UpdateDobDTO;
import com.thoughtfocus.project.dto.UpdateGenderDTO;
import com.thoughtfocus.project.dto.UpdatePasswordDTO;

public interface UpdateService {
	public String updatePassword(UpdatePasswordDTO dto);

	public String updateDob(UpdateDobDTO dto);

	public String updateGender(UpdateGenderDTO dto);
}
