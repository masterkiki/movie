package com.pks.movie.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pks.movie.movie.model.Movie;
import com.pks.movie.movie.model.MovieDetail;

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

	public List<Movie> selectMovie();
	
	public int updateAudience(
			@Param("movieId") int movieId
			, @Param("audience") int audience);
	
	public MovieDetail selectMovieById(@Param("movieId") int movieId);
	
	public int deleteMovie(@Param("movieId") int movieId);	
	
	 
	public Movie selectMovie1(@Param("id") int id);
}
