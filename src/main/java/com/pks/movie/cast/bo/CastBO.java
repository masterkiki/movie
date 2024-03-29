package com.pks.movie.cast.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.cast.dao.CastDAO;
import com.pks.movie.cast.model.Cast;

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
	
	public List<Cast> getCharacterName(int moiveId) {
		return castDAO.selectCastBymoiveId(moiveId);
	}
	
	public Cast getCharacterName1(int castingId) {
		return castDAO.selectCastBymoiveId1(castingId);
	}
	
	public Cast getCharacterNameByActorId(int actorId) {
		return castDAO.selectCharacterNameByActorId(actorId);
		
	}
}
