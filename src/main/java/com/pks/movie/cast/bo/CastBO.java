package com.pks.movie.cast.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.cast.dao.CastDAO;

@Service
public class CastBO {
	
	@Autowired
	private CastDAO castDAO;
	
	public int addCast(
			int movieId
			, int actorId
			, String charactername) {
		return castDAO.insertCast(movieId, actorId, charactername);
	}
	
	public getCharacterName(moiveId) {
		
	}
}
