package com.main.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entities.Loai;
import com.main.repository.LoaiRepository;
import com.main.service.LoaiService;

@Service
public class LoaiImpl implements LoaiService{

	@Autowired
	private LoaiRepository loaiRepository;

	@Override
	public boolean addLoai(Loai loai) {
		List<Loai> listLoai=findByTenLoai(loai.getTenLoai());

		if(listLoai.size()>=1) {

			return false;

		}

		loaiRepository.save(loai);

		return true;
	}

	@Override
	public boolean deleteLoai(ObjectId idLoaiId) {
		// TODO Auto-generated method stub

		Loai loai=findById(idLoaiId);

		if(loai==null) {

			return false;

		}

		loaiRepository.delete(loai);

		return true;
	}

	@Override
	public boolean updateLoai(Loai loai, ObjectId objectId) {
		// TODO Auto-generated method stub

		Loai loaiFind=findById(objectId);

		if(loai==null) {

			return false;

		}
		
		if(loai.getTenLoai()!=null) {
			
			loaiFind.setTenLoai(loai.getTenLoai());
			
		}

		return true;
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
