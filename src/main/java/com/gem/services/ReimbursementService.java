package com.gem.services;

import java.util.List;

import com.gem.daos.ReimbursementDao;
import com.gem.models.ReimbursementRequest;

public class ReimbursementService {
	private ReimbursementDao rd = new ReimbursementDao();
	
	public ReimbursementService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<ReimbursementRequest> findByUserId(int userId){
		return rd.findByUserId(userId);
	}
	
	public List<ReimbursementRequest> findAll(){
		return rd.findAll();
	}
	
	public int update(ReimbursementRequest rr) {
		return rd.update(rr);
	}

	public int create(ReimbursementRequest rr) {
		return rd.create(rr);
	}
}
