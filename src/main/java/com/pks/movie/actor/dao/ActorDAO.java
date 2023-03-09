package com.pks.movie.actor.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorDAO {

	public int addActor(
			@Param("movieId") int moiveId
			,@Param("actor") String actor);
	
	
}
