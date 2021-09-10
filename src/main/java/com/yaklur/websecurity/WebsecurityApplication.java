package com.yaklur.websecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class WebsecurityApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(WebsecurityApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		//http.csrf().disable().httpBasic();
		http
				.authorizeRequests().antMatchers("/employees/home").permitAll()
				.anyRequest().authenticated()
				.and().formLogin()
				.and().httpBasic();
	}
}
