package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Service
@Setter
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberDAO memberDAO;
	
	public MemberService() {
		System.out.println("MemberService 생성됨");
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO m = memberDAO.findById(username);
		UserDetails user = null;
		if(m != null) {
			user = User.builder().username(username).password(m.getM_pw()).roles(m.getM_role()).build();
		}else {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

}