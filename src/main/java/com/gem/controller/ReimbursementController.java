package com.gem.controller;

import java.util.List;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gem.models.ReimbursementRequest;
import com.gem.services.ReimbursementService;

public class ReimbursementController {
	private ReimbursementService rs = new ReimbursementService();
	
	public ReimbursementController(ReimbursementService rs) {
		this.rs = rs;
	}
	
	public ReimbursementController() {
		
	}
	
	public void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ReimbursementRequest rRequest = new ObjectMapper().readValue(request.getInputStream(), ReimbursementRequest.class);
		int userId = (int) request.getSession().getAttribute("userId");
		rRequest.setDwarfMinerId(userId);
		rRequest.setSubmitted(new Date(System.currentTimeMillis()));
		int result = rs.create(rRequest);
	}
	
	public void sendAll(HttpServletRequest request, HttpServletResponse response) {
		List<ReimbursementRequest> reimbursements = new ArrayList<>();
		reimbursements = rs.findAll();
		try {
			response.getWriter().println(new ObjectMapper().writeValueAsString(reimbursements));
		} catch(IOException e) {
			
		}
	}
	
	public void sendUserAll(HttpServletRequest request, HttpServletResponse response) {
		int userId = (int) request.getSession().getAttribute("userId");
		List<ReimbursementRequest> reimbursements = new ArrayList<>();
		reimbursements = rs.findByUserId(userId);
		try {
			response.getWriter().println(new ObjectMapper().writeValueAsString(reimbursements));
		} catch(IOException e) {
			
		}
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) {
		int overSeerId = (int) request.getSession().getAttribute("userId");
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			ReimbursementRequest rr = mapper.readValue(request.getInputStream(), ReimbursementRequest.class);
			rr.setDwarfOverseerId(overSeerId);
			rr.setResolved(new Date(System.currentTimeMillis()));
			
			int result = rs.update(rr);
		} catch(IOException e) {}
	}
}
