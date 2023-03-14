package com.pks.movie.actor.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pks.movie.actor.model.Actor;

@Repository
public interface ActorDAO {

	public int addActor(
			@Param("movieId") int moiveId
			,@Param("actor") String actor);
	
	
	public Actor selectActorByMovieId(@Param("movieId") int movieId);
	
}
