package com.main.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entities.Loai;
import com.main.model.ErrorResponse;
import com.main.repository.LoaiRepository;
import com.main.service.LoaiService;

@Service
public class LoaiImpl implements LoaiService{

	@Autowired
	private LoaiRepository loaiRepository;

	@Override
	public ErrorResponse addLoai(Loai loai) {
		List<Loai> listLoai=findByTenLoai(loai.getTenLoai());

		if(listLoai.size()>=1) {

			return new ErrorResponse("loại này đã tồn tại", false);

		}

		loaiRepository.save(loai);

		return new ErrorResponse("thêm thành công", true);
	}

	@Override
	public ErrorResponse deleteLoai(ObjectId idLoaiId) {
		// TODO Auto-generated method stub

		Loai loai=findById(idLoaiId);

		if(loai==null) {

			return new ErrorResponse("loại này không tồn tại", true);

		}

		loaiRepository.delete(loai);

		return new ErrorResponse("xóa thành công", true);
	}

	@Override
	public ErrorResponse updateLoai(Loai loai, ObjectId objectId) {
		// TODO Auto-generated method stub

		Loai loaiFind=findById(objectId);

		if(loai==null) {

			return new ErrorResponse("loại này không tồn tại", true);

		}
		
		if(loai.getTenLoai()!=null) {
			
			loaiFind.setTenLoai(loai.getTenLoai());
			
		}

		return new ErrorResponse("cập nhập thành công", true);
	}

	@Override
	public Loai findById(ObjectId objectId) {
		
		Optional<Loai> loaiOptional=loaiRepository.findById(objectId);
		
		if(loaiOptional.isPresent()) {
		
			return loaiOptional.get();
		
		}
		
		return null;
	}

	@Override
	public List<Loai> findByTenLoai(String tenLoai) {
		// TODO Auto-generated method stub
		return loaiRepository.findByTenLoai(tenLoai);
	}

	@Override
	public List<Loai> listAll() {
		// TODO Auto-generated method stub
		return loaiRepository.findAll();
	}

}
