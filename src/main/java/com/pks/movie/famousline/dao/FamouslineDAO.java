package com.pks.movie.famousline.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FamouslineDAO {

	public int insertFamousLine(
			@Param("userId") int userId
			, @Param("movieId") int movieId
			, @Param("actorId") int actorId
			, @Param("famousline") String famousline
			, @Param("explain") String explain);
	
}
