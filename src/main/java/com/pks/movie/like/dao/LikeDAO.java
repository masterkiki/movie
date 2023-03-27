package com.pks.movie.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {

	public int insertLike(
			@Param("userId") int userId
			, @Param("divisionId") int divisionId
			, @Param("type") String type);
}
