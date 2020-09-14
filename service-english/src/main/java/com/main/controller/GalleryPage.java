package com.main.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.entities.TuDien;
import com.main.model.ErrorResponse;
import com.main.service.LoaiService;
import com.main.service.TuDienService;

@Controller
@RequestMapping(value = "/")
public class GalleryPage {

	final static String galeryPage="gallery.html";
	
	//To catch trim
	@InitBinder
	public void initBinder ( WebDataBinder binder ){
		
		StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
		
		binder.registerCustomEditor(String.class, stringtrimmer);
	}

	@Autowired
	private LoaiService loaiService;

	@Autowired
	private TuDienService tuDienService;

	//init data before access html
	public void initDataHomePage(Model model) {
		model.addAttribute("loais", loaiService.listAll());

		model.addAttribute("tuDiens", tuDienService.danhSachTuDien());

		model.addAttribute("tuDien", new TuDien());

	}

	//home page
	@RequestMapping("/galery")
	public String homePage(Model model) {
		System.out.println("galery");

		initDataHomePage(model);

		return galeryPage;
	}

	
	//save data
	@RequestMapping("/submit")
	public String submitTuDien(@ModelAttribute @Validated TuDien tuDien,BindingResult result,Model model) {
		if(tuDien==null) {

			return "redirect:/";

		}

		initDataHomePage(model);

		if(result.hasErrors()) {

			model.addAttribute("errorAdd", "lỗi chưa nhập 1 trong 2 field vn-en");

			return galeryPage;
		}

		ErrorResponse errorResponse=tuDienService.addTuDien(tuDien);

		model.addAttribute("errorAdd",errorResponse.getMessage());

		initDataHomePage(model);

		return galeryPage;
	}

//	//delete data
//	@RequestMapping( "/xoa/{id}")
//	public String submitTuDien(@PathVariable("id") String id,Model model) {
//
//		System.out.println("ok");
//		
////		tuDienService.deleteTuDien(new ObjectId(id));
//
//		model.addAttribute("statusDelete","xóa thành công");
//		
//		initDataHomePage(model);
//
//		return homePage;
//	}





}
