package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
 
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/index/**").permitAll()
			.anyRequest().authenticated()			
			.antMatchers("/css/**").permitAll()
			.and()		
		.formLogin()
			.loginPage("/login").permitAll()
			.and()
		.logout()
			.permitAll();
		http.csrf().disable();
	}
	
	
	
	
	/*
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.inMemoryAuthentication()
				.withUser("user").password("pass").roles("USER");
	}
	*/
	
	
	
}
