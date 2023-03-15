package com.pks.movie.famousline.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface FamouslineDAO {

	public int insertFamousLine(
			int userId
			, int movieId
			, String famousline);
	
}
