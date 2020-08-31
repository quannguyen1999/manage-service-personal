package com.main.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.entities.TuDien;
import com.main.service.LoaiService;
import com.main.service.TuDienService;

@Controller
@RequestMapping(value = "/")
public class HomePage {
	@Autowired
	private LoaiService loaiService;

	@Autowired
	private TuDienService tuDienService;
	
	public void initDataHomePage(Model model) {
		model.addAttribute("loais", loaiService.listAll());

		model.addAttribute("tuDiens", tuDienService.danhSachTuDien());
		
		model.addAttribute("tuDien", new TuDien());

	}
	
	@RequestMapping
	public String homePage(Model model) {
		System.out.println("home page");
		
		initDataHomePage(model);
		
		return "homePage";
	}

	@RequestMapping("/submit")
	public String submitTuDien(@ModelAttribute @Validated TuDien tuDien,BindingResult result,Model model) {
		if(tuDien==null) {
			
			return "redirect:/";
			
		}
		
		if(result.hasErrors()) {
			model.addAttribute("errorAdd", "lỗi vn-en");
			return "homePage";
		}
		
		if(tuDienService.addTuDien(tuDien).isType()==true) {
			
			model.addAttribute("errorAdd", "Thêm thành công");
			
		}else{
			
			model.addAttribute("errorAdd", "Thêm không thành công");
			
		};
		
		initDataHomePage(model);
		
		return "homePage";
	}
	
	@RequestMapping("/xoa/{id}")
	public String submitTuDien(@PathVariable("id") String id,Model model) {
		
		System.out.println("xoa");
		
		tuDienService.deleteTuDien(new ObjectId(id));
		
		initDataHomePage(model);
		
		return "homePage";
	}
	
	



}
