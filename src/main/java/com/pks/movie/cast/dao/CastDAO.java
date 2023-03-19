package com.pks.movie.cast.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CastDAO {

	public int insertCast(
			@Param("movieId") int movieId 
			, @Param("actorId") int actorId
			, @Param("charactername") String charactername);
			
}
