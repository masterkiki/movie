package com.pks.movie.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {

	public int insertLike(
			@Param("userId") int userId
			, @Param("famouslineId") int famouslineId
			, @Param("divisionId") int divisionId);
}
