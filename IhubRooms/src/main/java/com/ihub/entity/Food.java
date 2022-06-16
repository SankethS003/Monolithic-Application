package com.ihub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food {
	@Id
	@Column(nullable = false)
	private int fid;
	@Column(nullable = false)
	private String ftype;
	@Column(nullable = false)
	private int fcost;
	
	

//DTO to entity
	
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public int getFcost() {
		return fcost;
	}

	public void setFcost(int fcost) {
		this.fcost = fcost;
	}

}
