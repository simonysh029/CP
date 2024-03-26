package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	//전체 권한
		http.authorizeHttpRequests()
		.requestMatchers("/","/page/main","/page/join").permitAll()
		//.requestMatchers("/admin/**").hasRole("admin")
		.anyRequest().authenticated();
	//login 권한
		http.formLogin()
		.loginPage("/page/login")
		.permitAll()
		.defaultSuccessUrl("/page/main");
	//logout 권한
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/page/main");
	//프롬프트 없이 바로 인증, 보안절차 생략코드
		http.httpBasic();
		return http.build();
	}
	
}
