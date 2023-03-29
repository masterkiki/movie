package com.pks.movie.actor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pks.movie.actor.model.Actor;

@Repository
public interface ActorDAO {

	public int addActor(
			@Param("movieId") int moiveId
			, @Param("actor") String actor
			, @Param("imagePath") String imagePath);
	
	
	public Actor selectActorByMovieId(@Param("actorId") int actorId);
	
	
	public List<Actor> selectActorList(@Param("movieId") int movieId);
	
}
