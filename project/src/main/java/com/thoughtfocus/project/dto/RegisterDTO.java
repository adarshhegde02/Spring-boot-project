package com.thoughtfocus.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegisterDTO {
	private String name;
	private String email;
	private String password;
    private String confirmPassword;
	private long contact;
}
