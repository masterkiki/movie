package com.pks.movie.famousline.model;

import java.util.Date;

public class FamouslineDetail {
	
	private int id;
	private int userId;
	private int movieId;
	private int actorId;
	private int castinId;
	private String famousline;
	private String explain;
	private Date createdAt;
	private Date updatedAt;
	
	
	
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
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getCastinId() {
		return castinId;
	}
	public void setCastinId(int castinId) {
		this.castinId = castinId;
	}
	public String getFamousline() {
		return famousline;
	}
	public void setFamousline(String famousline) {
		this.famousline = famousline;
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
