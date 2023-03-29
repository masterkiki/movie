package com.pks.movie.cast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pks.movie.cast.model.Cast;

@Repository
public interface CastDAO {

	public int insertCast(
			@Param("movieId") int movieId 
			, @Param("actorId") int actorId
			, @Param("charactername") String charactername);
	
	public List<Cast> selectCastBymoiveId(@Param("movieId") int movieId);
	
	public Cast selectCastBymoiveId1(@Param("castingId") int castingId);
	
	public Cast selectCharacterNameByActorId(@Param("actorId") int actorId);
			
}
