package com.main.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.entities.Loai;
import com.main.service.LoaiService;

@Component
public class InitData implements CommandLineRunner{

	@Autowired
	private LoaiService loaiService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Loai loai=new Loai("none");
		
//		System.out.println(loaiService.addLoai(loai));
	}
	
}
