package com.pks.movie.famousline.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.famousline.dao.FamouslineDAO;

@Service
public class FamouslineBO {
	
	@Autowired
	private FamouslineDAO famouslineDAO;
	

	public int addFamousLine(
			int userId
			, int movieId
			, int actorId
			, String famousline
			, String explain) {
		
		return famouslineDAO.insertFamousLine(userId, movieId, actorId, famousline, explain);
		
	}
	
}
