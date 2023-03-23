package com.pks.movie.famousline.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FamouslineDAO {

	public int insertFamousLine(
			@Param("movieId") int movieId
			, @Param("actorId") int actorId
			, @Param("castingId") int castingId
			, @Param("famousline") String famousline
			, @Param("explain") String explain);
	
}
