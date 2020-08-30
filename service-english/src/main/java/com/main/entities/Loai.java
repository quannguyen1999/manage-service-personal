package com.main.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Loai {
	@Id
	private ObjectId idLoai;
	
	private String tenLoai;

	public Loai(String tenLoai) {
		super();
		this.tenLoai = tenLoai;
	}

	
}
