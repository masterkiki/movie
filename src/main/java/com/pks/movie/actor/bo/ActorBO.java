package com.pks.movie.actor.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.actor.dao.ActorDAO;
import com.pks.movie.actor.model.Actor;
import com.pks.movie.actor.model.ActorDetail;
import com.pks.movie.cast.bo.CastBO;
import com.pks.movie.cast.model.Cast;

@Service
public class ActorBO {
	
	@Autowired
	private ActorDAO actorDAO;
	
	@Autowired
	private CastBO castBO;
	
	public int addActor(
			int movieId
			, String actor) {
		
		return actorDAO.addActor(movieId, actor);
		
	}
	
	public Actor getActorByMovieId(int movieId) {
		return actorDAO.selectActorByMovieId(movieId);
	}
	
	public List<Actor> getActorList(int movieId){
		return actorDAO.selectActorList(movieId);
	}
	
	
	public List<ActorDetail> getActorDetailList(int movieId){
		
		List<Actor> actorList = actorDAO.selectActorList(movieId);
		
		List<ActorDetail> ActorDetailList = new ArrayList<>();
		
		for(Actor actor:actorList) {
			ActorDetail actorDetail = new ActorDetail();
			
			Cast cast = castBO.getCharacterName1(movieId);
			
			actorDetail.setId(actor.getId());
			actorDetail.setMoiveId(actor.getMovieId());
			actorDetail.setCharactername(cast.getCharactername());
			actorDetail.setActor(actor.getActor());
			
			ActorDetailList.add(actorDetail);
		}
		return ActorDetailList;
	}

}
