package com.example.demo.auth.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.auth.dto.LoginFormDto;
import com.example.demo.auth.dto.MemberDto;
import com.example.demo.auth.dto.RegistFormDto;
import com.example.demo.auth.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@RequestMapping("/login")
	public String loginForm(@ModelAttribute("login")LoginFormDto loginFormData) {
		log.info("{}:{}",AuthController.class,"login-GET");
		return "login";
	}
	
	@PostMapping("/loginProc")
	@ResponseBody
	public String loginProc(@ModelAttribute("login")LoginFormDto loginFormDto,Model model) {
		log.info("email={},pwd={}",loginFormDto.getEmail(),loginFormDto.getPwd());
		int result=authService.authenticate(loginFormDto);
		if (result==1) {
			return "<script>alert('로그인 성공!');location.href='/';</script>";
		}else {
			return "<script>alert('로그인 실패');</script>";
		}
	}
	
	
	@GetMapping("/regist")
	public String registForm() {
		log.info("{}:{}",AuthController.class,"regist-GET");
		return "regist";
	}
	
	@PostMapping("regist")
	public String registProc(@ModelAttribute RegistFormDto registFormData) {
		log.info("email={},pwd={}",registFormData.getEmail(),registFormData.getPwd());
//		String encPwd = pwdEncoder.encode(registFormData.getPwd());
		
		MemberDto dto=MemberDto.builder()
			.email(registFormData.getEmail())
			.pwd(registFormData.getPwd())
			.build();
		
		authService.insert(dto);
		
		return "redirect:/auth/login";
	}
}
