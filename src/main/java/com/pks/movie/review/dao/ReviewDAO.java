package com.pks.movie.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pks.movie.review.model.Review;

@Repository
public interface ReviewDAO {

	public int insertReview(
			@Param("userId") int userId
			, @Param("movieId") int movieId
			, @Param("review") String review
			, @Param("point") int point);
	
	
	public List<Review> selectReview(@Param("movieId") int movieId);
	
	public Double selectPointByMovieId(@Param("movieId") int movieId);
	
	public List<Review> selectReviewById();
	
}
