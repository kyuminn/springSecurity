package com.example.demo.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistFormDto {
	private String email;
	private String pwd;
	private String confirmPwd;
}
