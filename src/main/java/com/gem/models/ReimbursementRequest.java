package com.gem.models;

import java.sql.Date;

public class ReimbursementRequest {
	private int id;
	private int amount;
	private Date submitted;
	private Date resolved;
	private String description;
	private int dwarfMinerId;
	private int dwarfOverseerId;
	
	private String type;
	private String status;
	
	
	
	public ReimbursementRequest(int id, int amount, Date submitted, Date resolved, String description,
			int dwarfMinerId, int dwarfOverseerId, int reimburseType) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.dwarfMinerId = dwarfMinerId;
		this.dwarfOverseerId = dwarfOverseerId;
	}
	
	public ReimbursementRequest(int id, int amount, Date submitted, Date resolved, String description, int dwarfMinerId, String status, String type) {
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.dwarfMinerId = dwarfMinerId;
		this.description = description;
		this.status = status;
		this.type = type;
	}
	// for testing create purposes
	public ReimbursementRequest(int amount, String description, String type, int dwarfMinerId) {
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.dwarfMinerId = dwarfMinerId;
	}
	
	// received from the front end for creation
	public ReimbursementRequest(int amount, String description, String type) {
		this.amount = amount;
		this.description = description;
		this.type = type;
	}
	
	// for testing update purposes
	public ReimbursementRequest(int id, String status, int dwarfOverseerId) {
		this.id = id;
		this.status = status;
		this.dwarfOverseerId = dwarfOverseerId;
	}
	
	// received from the frontend for updating
	public ReimbursementRequest(int id, String status) {
		this.id = id;
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return "ReimbursementRequest [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", dwarfMinerId=" + dwarfMinerId + ", dwarfOverseerId="
				+ dwarfOverseerId + ", type=" + type + ", status=" + status + "]";
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ReimbursementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}
	public Date getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDwarfMinerId() {
		return dwarfMinerId;
	}
	public void setDwarfMinerId(int dwarfMinerId) {
		this.dwarfMinerId = dwarfMinerId;
	}
	public int getDwarfOverseerId() {
		return dwarfOverseerId;
	}
	public void setDwarfOverseerId(int dwarfOverseerId) {
		this.dwarfOverseerId = dwarfOverseerId;
	}
	
	
	
	
}
