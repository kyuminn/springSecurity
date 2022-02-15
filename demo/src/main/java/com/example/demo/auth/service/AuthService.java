package com.example.demo.auth.service;

import java.util.Optional;

import com.example.demo.auth.dto.LoginFormDto;
import com.example.demo.auth.dto.MemberDto;

public interface AuthService {
	void insert(MemberDto memberDto);
	int authenticate(LoginFormDto dto);
	
}
