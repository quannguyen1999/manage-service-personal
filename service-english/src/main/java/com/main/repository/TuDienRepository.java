package com.main.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.main.entities.TuDien;

@Repository
public interface TuDienRepository extends MongoRepository<TuDien, ObjectId>{
}