package com.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomePage {
	final static String homePage="homePage.html";
	//home page
	@RequestMapping
	public String homePage(Model model) {
		System.out.println("home page");
		
		return homePage;
	}
}
