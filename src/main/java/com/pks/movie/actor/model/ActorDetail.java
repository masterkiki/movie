package com.pks.movie.actor.model;

import java.util.Date;

public class ActorDetail {
	
	private int id;
	private int moiveId;
	private int actorId;
	private String actor;
	private int castingId;
	private String charactername;
	private int famouslineId;
	private String famousline;
	private String explain;
	private Date createdAt;
	
	
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
	private Date updatedAt;
	
	
	
	
	
	public int getFamouslineId() {
		return famouslineId;
	}
	public void setFamouslineId(int famouslineId) {
		this.famouslineId = famouslineId;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoiveId() {
		return moiveId;
	}
	public void setMoiveId(int moiveId) {
		this.moiveId = moiveId;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getCastingId() {
		return castingId;
	}
	public void setCastingId(int castingId) {
		this.castingId = castingId;
	}
	public String getCharactername() {
		return charactername;
	}
	public void setCharactername(String charactername) {
		this.charactername = charactername;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	
	

}
