package com.main.restController;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.ErrorResponse;
import com.main.service.LoaiService;
import com.main.service.TuDienService;

@RestController
@RequestMapping(value = "/api/")
public class HomePageRest {

	@Autowired
	private LoaiService loaiService;

	@Autowired
	private TuDienService tuDienService;
	
	//delete data
	@RequestMapping( "/xoa/{id}")
	public ErrorResponse submitTuDien(@PathVariable("id") String id,Model model) throws Exception {
		return tuDienService.deleteTuDien(new ObjectId(id));
	}
}
