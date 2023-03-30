package com.pks.movie.famousline.model;

import java.util.Date;

public class FamouslineDetail {
	
	private int id;
	private int userId;
	private int movieId;
	private int actorId;
	private int castingId;
	private String famousline;
	private String explain;
	private String charactername;
	private String actor;
	private String imagePath;
	private String nickname;
	private String divisionId;
	private int likeCount;
	private boolean isLike;
	private Date createdAt;
	private Date updatedAt;
	
	
	
	
	
	public boolean isLike() {
		return isLike;
	}
	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}
	public String getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getCharactername() {
		return charactername;
	}
	public void setCharactername(String charactername) {
		this.charactername = charactername;
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
	public int getCastingId() {
		return castingId;
	}
	public void setCastingId(int castinId) {
		this.castingId = castinId;
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
