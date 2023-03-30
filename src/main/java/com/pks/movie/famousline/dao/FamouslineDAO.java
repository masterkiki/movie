package com.pks.movie.famousline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pks.movie.famousline.model.Famousline;


@Repository
public interface FamouslineDAO {

	public int insertFamousLine(
			@Param("userId") int userId
			, @Param("movieId") int movieId
			, @Param("actorId") int actorId
			, @Param("castingId") int castingId
			, @Param("famousline") String famousline
			, @Param("explain") String explain);
	
	public List<Famousline> selectFamousLine(@Param("movieId") int movieId);
		
	public int countFamouslineByMovieId(@Param("movieId") int movieId);
	
}
