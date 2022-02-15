package com.example.demo.auth.service;



import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.auth.dto.LoginFormDto;
import com.example.demo.auth.dto.MemberDto;
import com.example.demo.auth.repository.AuthRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService{
	
	private final AuthRepository authRepository;
	private final BCryptPasswordEncoder pwdEncoder;
	
	@Override
	public void insert(MemberDto memberDto) {
		String encPwd = pwdEncoder.encode(memberDto.getPwd());
		memberDto.setPwd(encPwd);
		authRepository.insert(memberDto);
		
	}

	@Override
	public int authenticate(LoginFormDto dto) {
		int result=-1;
		Optional<MemberDto> memberDto=authRepository.selectByEmail(dto.getEmail());
		if(memberDto.isEmpty()) {
			result = 0; // 회원정보 없는 경우
		}
		if(pwdEncoder.matches(dto.getPwd(),memberDto.get().getPwd())) {
			result = 1 ; // 회원정보 일치
		}
		log.info("=====login authenticate result={}",result);
		return result;
	}


}
