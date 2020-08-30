package com.main.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class TuDien {
	@Id
	private ObjectId idTuDien;
	
	private String vietnamese;
	
	private String english;
	
	private String information;
	
	@DBRef
	private Loai idLoai;
}
