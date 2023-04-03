package com.pks.movie.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.like.dao.LikeDAO;
import com.pks.movie.like.model.Like;

@Service
public class LikeBO {
	
	@Autowired
	private LikeDAO likeDAO;
	
	public int addLike(
			int userId
			, int rowId
			, int divisionId) {
		int count = likeDAO.selectLikeCountByUserId(userId, rowId, divisionId);
		
		if(count == 0) {
			return likeDAO.insertLike(userId, rowId, divisionId);
		} else {
			return likeDAO.deleteLike(userId, rowId, divisionId);
		}
	}
	
	
	// 좋아요 개수 리턴하는 매소드
	public int likeCount(int rowId , int divisionId) {
		return likeDAO.likeCount(rowId, divisionId);
	}
	
//	public Like selectLike(int rowId) {
//		return likeDAO.selectLike(rowId);
//	}
	
	public boolean isLike(int userId, int rowId, int divisionId) {
		
		int count = likeDAO.selectLikeCountByUserId(userId, rowId, divisionId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public int deleteLike(int rowId, int userId, int divisionId) {
		return likeDAO.deleteLike(userId, rowId, divisionId);
	}
	
	
	
	
}
