package com.pks.movie.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pks.movie.like.model.Like;

@Repository
public interface LikeDAO {

	public int insertLike(
			@Param("userId") int userId
			, @Param("rowId") int rowId
			, @Param("divisionId") int divisionId);
	
	public int likeCount(
			@Param("rowId") int rowId
			, @Param("divisionId") int divisionId);
	
	public Like selectLike(@Param("rowId") int rowId);
	
	public int selectLikeCountByUserId(
			@Param("userId") int userId
			, @Param("rowId") int rowId
			, @Param("divisionId") int divisionId);

	
	public int deleteLike(
			@Param("userId") int userId
			, @Param("rowId") int rowId
			, @Param("divisionId") int divisionId);	
	
	
}

