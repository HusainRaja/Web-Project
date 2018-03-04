package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/Login")
	public String showLogin() {
		return "Login";
	}
	
	@RequestMapping("/AboutUs")
	public String showAboutUs() {
		return "AboutUs";
	}
		
	@RequestMapping("/ContactUs")
	public String showContactUs() {
		return "ContactUs";
	}
	
	@RequestMapping("/Register")
	public String showRegister() {
		return "Register";
	}
	
	@RequestMapping("/")
	public String showHomePage() {
		return "Header";
	}
}
