package com.seo.dj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/handy/users", method = RequestMethod.GET)
	public String getBlockServices() {
		return "index";
	}
}
