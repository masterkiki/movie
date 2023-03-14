package com.pks.movie.actor.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.actor.dao.ActorDAO;
import com.pks.movie.actor.model.Actor;

@Service
public class ActorBO {
	
	@Autowired
	private ActorDAO actorDAO;
	
	
	public int addActor(
			int movieId
			, String actor) {
		
		return actorDAO.addActor(movieId, actor);
		
	}
	
	public Actor getActorByMovieId(int movieId) {
		return actorDAO.selectActorByMovieId(movieId);
	}

}
