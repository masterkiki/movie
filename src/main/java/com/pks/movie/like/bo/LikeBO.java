package com.pks.movie.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.like.dao.LikeDAO;

@Service
public class LikeBO {
	
	@Autowired
	private LikeDAO likeDAO;
	
	public int addLike(
			int userId
			, int famouslineId
			, int divisionId) {
		return likeDAO.insertLike(userId, famouslineId, divisionId);
	}
	
}
