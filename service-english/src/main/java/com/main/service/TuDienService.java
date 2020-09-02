package com.main.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.main.entities.TuDien;
import com.main.model.ErrorResponse;

public interface TuDienService {
	public ErrorResponse addTuDien(TuDien tuDien);
	
	public ErrorResponse deleteTuDien(ObjectId idTuDien);
	
	public ErrorResponse updateTuDien(TuDien tuDien);
	
	public TuDien findById(ObjectId objectId);
	
	public List<TuDien> danhSachTuDien();
}
