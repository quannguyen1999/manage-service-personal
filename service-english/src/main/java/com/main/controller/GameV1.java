package com.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/v1")
public class GameV1 {
	final static String gameV1="gamev1.html";

	//home game v1
	@RequestMapping
	public String homePage(Model model) {
		
		return gameV1;
		
	}
}
