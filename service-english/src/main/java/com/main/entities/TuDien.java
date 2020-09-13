package com.main.entities;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
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
	
	private Date dateCreate;
	
	private Date dateUpdate;
}
