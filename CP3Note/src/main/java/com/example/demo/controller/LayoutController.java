package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.service.MemberService;
import com.example.demo.vo.MemberVO;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@RequestMapping
@Setter
public class LayoutController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberDAO dao;
	@Autowired
	private MemberService ms;
	
	@GetMapping("page/login")
	public void loginForm() {
	}
	@PostMapping("page/login")
	public String loginSubmit(HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		session.setAttribute("id", id);
		String view = "/page/main";
		return view;
	}
	@GetMapping("page/join")
	public void joinForm() {	
	}
	@PostMapping("page/join")
	public String joinSubmit(MemberVO m) {
		m.setM_pw(passwordEncoder.encode(m.getM_pw()));
		m.setM_mile(0);
		dao.insert(m);
		String view = "redirect:/";
		return view;
	}

	@GetMapping("/")
	public String index() {
		return "main";
	}
}
