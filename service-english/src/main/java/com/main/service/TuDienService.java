package com.main.service;

import org.bson.types.ObjectId;

import com.main.entities.TuDien;

public interface TuDienService {
	public boolean addTuDien(TuDien tuDien);
	
	public boolean deleteTuDien(TuDien tuDien);
	
	public boolean updateTuDien(TuDien tuDien,ObjectId objectId);
	
	public TuDien findById(ObjectId objectId);
}
