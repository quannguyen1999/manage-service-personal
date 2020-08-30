package com.main.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.main.entities.Loai;

public interface LoaiService {
	public boolean addLoai(Loai loai);
	
	public boolean deleteLoai(ObjectId idLoaiId);
	
	public boolean updateLoai(Loai loai,ObjectId objectId);
	
	public Loai findById(ObjectId objectId);
	
	public List<Loai> findByTenLoai(String tenLoai);
	
	public List<Loai> listAll();
}
