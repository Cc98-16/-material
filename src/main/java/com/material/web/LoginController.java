package com.material.web;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.material.config.WebSecurityConfig;
import com.material.service.UserService;
import com.material.utils.Result;
import com.material.valid.LoginForm;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/login")
	public String Login(){
		return "login";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public Map<String, Object> login(HttpSession session,@Valid LoginForm loginForm){
		userService.login(session,loginForm);
		return Result.toUrl("/index");
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 移除session
		session.removeAttribute(WebSecurityConfig.USERID);
		session.removeAttribute(WebSecurityConfig.USER);
		return "redirect:/login";
	}
}
