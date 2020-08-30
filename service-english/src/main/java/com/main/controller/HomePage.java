package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.service.LoaiService;

@Controller
@RequestMapping(value = "/")
public class HomePage {
	@Autowired
	private LoaiService loaiService;
	
	@RequestMapping
	public String homePage(Model model) {
		
		System.out.println("home page");
		
		model.addAttribute("loais", loaiService.listAll());
		
		return "client";
	}
	
	
}
