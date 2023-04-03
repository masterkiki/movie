package com.pks.movie.review.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.like.bo.LikeBO;
import com.pks.movie.movie.bo.MovieBO;
import com.pks.movie.movie.model.Movie;
import com.pks.movie.review.dao.ReviewDAO;
import com.pks.movie.review.model.Review;
import com.pks.movie.review.model.ReviewDetail;
import com.pks.movie.review.model.ReviewHome;
import com.pks.movie.user.bo.UserBO;
import com.pks.movie.user.model.User;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private LikeBO likeBO;
	
	@Autowired
	private MovieBO movieBO;
	
	public int addReview(
			int userId
			, int movieId
			, String review
			, int point) {
	 	return reviewDAO.insertReview(userId, movieId, review, point);
	}

	
	public List<Review> selectReview(int movieId){
		return reviewDAO.selectReview(movieId);
	}
	
	public List<ReviewDetail> getReviewDetailList(int movieId ,int userId){
		
		List<Review> reviewList = reviewDAO.selectReview(movieId);
		
		List<ReviewDetail> reviewDetailList = new ArrayList<>();
		
		for(Review review:reviewList) {
			ReviewDetail reviewDetail = new ReviewDetail();
			
			User user = userBO.selectUserById(review.getUserId());
			
			int likecount = likeBO.likeCount(review.getId(), 2);
			
			boolean like = likeBO.isLike(userId, review.getId() , 2);
			
			
			reviewDetail.setId(review.getId());
			reviewDetail.setUserId(user.getId());
			reviewDetail.setMovieId(review.getMovieId());
			reviewDetail.setReview(review.getReview());
			reviewDetail.setPoint(review.getPoint());
			reviewDetail.setCreatedAt(review.getCreatedAt());
			reviewDetail.setNickname(user.getNickname());
			reviewDetail.setLikeCount(likecount);
			reviewDetail.setLike(like);
			
			reviewDetailList.add(reviewDetail);
		}
		return reviewDetailList;
	}
	
	
	public double averagePoint(int movieId) {
		return reviewDAO.selectPointByMovieId(movieId);
	}
	
	
	public List<ReviewHome> getReviewDetailById(){
		
		
		List<Review> reviewList = reviewDAO.selectReviewById();
		
		List<ReviewHome> reviewHomeList = new ArrayList<>();
		
		for(Review review:reviewList) {
			
			
			Movie movie = movieBO.getMovieList1(review.getMovieId());
			
			User user = userBO.selectUserById(review.getUserId());
			
			ReviewHome reviewHome = new ReviewHome();
			
			reviewHome.setId(review.getId());
			reviewHome.setUserId(review.getUserId());
			reviewHome.setMoiveId(review.getMovieId());
			reviewHome.setReview(review.getReview());
			reviewHome.setPoint(review.getPoint());
			reviewHome.setDivisionId(review.getDivisionId());
			reviewHome.setImagePath(movie.getImagePath());
			reviewHome.setMovietitle(movie.getMovietitle());
			reviewHome.setNickname(user.getNickname());
			reviewHome.setCreatedAt(review.getCreatedAt());
			reviewHome.setMovietitle(movie.getMovietitle());
			
			reviewHomeList.add(reviewHome);
		}
		return reviewHomeList;
	}
	
	
	
}
