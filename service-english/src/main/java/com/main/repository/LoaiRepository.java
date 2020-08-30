package com.main.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.main.entities.Loai;

@Repository
public interface LoaiRepository extends MongoRepository<Loai,ObjectId>{
	List<Loai> findByTenLoai(String tenLoai);
}
