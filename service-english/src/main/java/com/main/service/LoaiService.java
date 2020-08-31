package com.main.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.main.entities.Loai;
import com.main.model.ErrorResponse;

public interface LoaiService {
	public ErrorResponse addLoai(Loai loai);
	
	public ErrorResponse deleteLoai(ObjectId idLoaiId);
	
	public ErrorResponse updateLoai(Loai loai,ObjectId objectId);
	
	public Loai findById(ObjectId objectId);
	
	public List<Loai> findByTenLoai(String tenLoai);
	
	public List<Loai> listAll();
}
