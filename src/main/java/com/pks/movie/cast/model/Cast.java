package com.pks.movie.cast.model;

public class Cast {
	
	private int id;
	private int actorId;
	private int movieId;
	private String charactername;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getCharactername() {
		return charactername;
	}
	public void setCharactername(String charactername) {
		this.charactername = charactername;
	}
	
	

}
