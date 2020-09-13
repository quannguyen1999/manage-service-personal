package com.main.impl;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entities.Loai;
import com.main.entities.TuDien;
import com.main.model.ErrorResponse;
import com.main.repository.TuDienRepository;
import com.main.service.LoaiService;
import com.main.service.TuDienService;

@Service
public class TuDienImpl implements TuDienService{

	@Autowired
	private TuDienRepository tuDienRepository;

	@Autowired
	private LoaiService loaiService;

	@Override
	public ErrorResponse addTuDien(TuDien tuDien) {
		
		tuDien.setDateCreate(new Date());
		
		System.out.println(tuDien.getDateCreate());
		
		if(tuDien.getInformation()==null || tuDien.getInformation().isEmpty()) {
		
			tuDien.setInformation("...");
		
		}
		
		List<Loai> loai=loaiService.findByTenLoai(tuDien.getIdLoai().getTenLoai());

		if(loai.size()<=0) {
			List<Loai> loaiDefault=loaiService.findByTenLoai("none");
			
			if(loaiDefault.size()<=0) {
				return new ErrorResponse("loại default không tồn tại", false);
			}
			
			tuDien.getIdLoai().setIdLoai(loaiDefault.get(0).getIdLoai());
			
		}else {
			tuDien.setIdLoai(loai.get(0));
			
		}
		
		List<TuDien> listTuDien=tuDienRepository.findByEnglish(tuDien.getEnglish());
		
		if(listTuDien.size()>=1) {
			
			return updateTuDien(tuDien);
			
		}
		
		tuDienRepository.save(tuDien);

		return new ErrorResponse("Thêm thàng công", true);
	}

	@Override
	public ErrorResponse deleteTuDien(ObjectId idTuDien) {
		// TODO Auto-generated method stub

		TuDien tuDien=findById(idTuDien);

		if(tuDien==null) {

			return new ErrorResponse("Từ điển này không tồn tại hoặc rỗng", false);

		}

		tuDienRepository.delete(tuDien);

		return new ErrorResponse("Xóa thành công", true);
	}

	@Override
	public ErrorResponse updateTuDien(TuDien tuDien) {
		
		List<TuDien> listTuDiens=tuDienRepository.findByEnglish(tuDien.getEnglish());
		
		if(listTuDiens.size()<=0) {
			
			return new ErrorResponse("english"+tuDien.getEnglish()+" này không tồn tại", false);
			
		}
		
		TuDien tuDienFindFirst=listTuDiens.get(0);
		
		if(tuDien.getVietnamese().isEmpty()==false) {
			
			tuDienFindFirst.setVietnamese(tuDien.getVietnamese());
		}
		
		if(tuDien.getInformation().isEmpty()==false) {
			
			tuDienFindFirst.setInformation(tuDien.getInformation());
			
		}
		
		if(tuDien.getIdLoai().getIdLoai()!=null) {
			
			tuDienFindFirst.setIdLoai(tuDien.getIdLoai());
			
		}
		
		tuDienFindFirst.setDateUpdate(new Date());
		
		tuDienRepository.save(tuDienFindFirst);
		
		return new ErrorResponse("cập nhập thành công", true);
	}

	@Override
	public TuDien findById(ObjectId objectId) {
		return tuDienRepository.findById(objectId).get();
	}

	@Override
	public List<TuDien> danhSachTuDien() {
		return tuDienRepository.findAll();
	}

}
