package com.pks.movie.movie.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface MovieDAO {

	public int addMovie(
			@Param("movietitle") String movietitle
			, @Param("genre") String genre
			, @Param("country") String country
			, @Param("releasedate") String releasedate
			, @Param("director") String director
			, @Param("imagePath") String iamgePath
			, @Param("story") String story);
	
}
