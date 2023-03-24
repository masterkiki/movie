package com.pks.movie.famousline.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.famousline.dao.FamouslineDAO;
import com.pks.movie.famousline.model.Famousline;

@Service
public class FamouslineBO {
	
	@Autowired
	private FamouslineDAO famouslineDAO;
	

	public int addFamousLine(
			int userId
			, int movieId
			, int actorId
			, int castingId
			, String famousline
			, String explain) {
		
		return famouslineDAO.insertFamousLine(userId ,movieId, actorId, castingId, famousline, explain);
	}
	
	public List<Famousline> selectFamousLine(int movieId){
		return famouslineDAO.selectFamousLine(movieId);
	}
	
}
