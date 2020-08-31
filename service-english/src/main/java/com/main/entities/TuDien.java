package com.main.entities;

import javax.validation.constraints.NotEmpty;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.annotations.NotThreadSafe;

import lombok.Data;

@Data
@Document
public class TuDien {
	@Id
	private ObjectId idTuDien;
	
	@NotEmpty
	private String vietnamese;
	
	@NotEmpty
	private String english;
	
	private String information;
	
	@DBRef
	private Loai idLoai;
}
