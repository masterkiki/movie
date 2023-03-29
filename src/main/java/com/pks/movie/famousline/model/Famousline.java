package com.pks.movie.famousline.model;

import java.util.Date;

public class Famousline {
	
	private int id;
	private int userId;
	private int moiveId;
	private int actorId;
	private int castingId;
	private String famousline;
	private String explain;
	private Date createdAt;
	private Date updatedAt;
	
	
	public String getFamousline() {
		return famousline;
	}
	public void setFamousline(String famousline) {
		this.famousline = famousline;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMoiveId() {
		return moiveId;
	}
	public void setMoiveId(int moiveId) {
		this.moiveId = moiveId;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getCastingId() {
		return castingId;
	}
	public void setCastingId(int castingId) {
		this.castingId = castingId;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
