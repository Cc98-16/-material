package com.material.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.material.utils.Confirms;

@Controller
public class ConfirmController {
	
	protected List<Confirms>  seconfirm;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/confirm")
	public String Confirm(HttpSession httpSession){
		seconfirm = (List<Confirms>) httpSession.getAttribute("seconfirm");
		System.out.println(seconfirm);
		return "/confirmorder";
	}
}
