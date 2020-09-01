package com.main.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entities.Loai;
import com.main.entities.TuDien;
import com.main.model.ErrorResponse;
import com.main.repository.TuDienRepository;
import com.main.service.LoaiService;
import com.main.service.TuDienService;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TuDienImpl implements TuDienService{

	@Autowired
	private TuDienRepository tuDienRepository;

	@Autowired
	private LoaiService loaiService;

	@Override
	public ErrorResponse addTuDien(TuDien tuDien) {

		if(tuDien.getInformation().isEmpty()) {
			tuDien.setInformation("...");
		}
		
		List<Loai> loai=loaiService.findByTenLoai(tuDien.getIdLoai().getTenLoai());

		if(loai.size()<=0) {

			List<Loai> loaiDefault=loaiService.findByTenLoai("none");
			
			System.out.println(loaiDefault.size());
			
			if(loaiDefault.size()<=0) {
				return new ErrorResponse("loại default không tồn tại", true);
			}
			
			tuDien.getIdLoai().setIdLoai(loaiDefault.get(0).getIdLoai());
			
		}else {
			
			tuDien.setIdLoai(loai.get(0));
			
		}
		
		tuDienRepository.save(tuDien);

		return new ErrorResponse("Thêm thàng công", true);
	}

	@Override
	public ErrorResponse deleteTuDien(ObjectId idTuDien) {
		// TODO Auto-generated method stub

		TuDien tuDien=findById(idTuDien);

		if(tuDien==null) {

			return new ErrorResponse("Từ điển này không tồn tại hoặc rỗng", true);

		}

		tuDienRepository.delete(tuDien);

		return new ErrorResponse("Xóa thành công", true);
	}

	@Override
	public ErrorResponse updateTuDien(TuDien tuDien, ObjectId objectId) {
		// TODO Auto-generated method stub
		return new ErrorResponse("cập nhập thành công", true);
	}

	@Override
	public TuDien findById(ObjectId objectId) {
		// TODO Auto-generated method stub
		return tuDienRepository.findById(objectId).get();
	}

	@Override
	public List<TuDien> danhSachTuDien() {
		// TODO Auto-generated method stub
		return tuDienRepository.findAll();
	}

}
