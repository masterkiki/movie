package com.pks.movie.famousline.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.famousline.dao.FamouslineDAO;

@Service
public class FamouslineBO {
	
	@Autowired
	private FamouslineDAO famouslineDAO;
	

	public int addFamousLine(
			 int movieId
			, int actorId
			, int castingId
			, String famousline
			, String explain) {
		
		return famouslineDAO.insertFamousLine(movieId, actorId, castingId, famousline, explain);
	}
	
}
