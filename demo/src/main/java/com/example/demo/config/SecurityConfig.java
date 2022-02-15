package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.auth.service.LoginFailHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.csrf().disable();
		
		http
			//.csrf().disable()
			.formLogin()
				.loginPage("/auth/login")
				.usernameParameter("email")
				.passwordParameter("pwd")
				.loginProcessingUrl("/auth/loginProc")
				.defaultSuccessUrl("/")
				
				//.failureUrl("/auth/login")
				.failureHandler(new LoginFailHandler());
			
		http.authorizeRequests().anyRequest().permitAll();
	}
	
	
}
