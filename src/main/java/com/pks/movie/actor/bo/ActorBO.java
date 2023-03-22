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

	public int addActor(int movieId, String actor) {

		return actorDAO.addActor(movieId, actor);

	}

	public Actor getActorByMovieId(int movieId) {
		return actorDAO.selectActorByMovieId(movieId);
	}

	public List<Actor> getActorList(int movieId) {
		return actorDAO.selectActorList(movieId);
	}

	public List<ActorDetail> getActorDetailList(int movieId) {

		List<Actor> actorList = actorDAO.selectActorList(movieId);

		List<ActorDetail> ActorDetailList = new ArrayList<>();

		List<Cast> castList = castBO.getCharacterName(movieId);
/*		 for(Actor actor:actorList) { ActorDetail actorDetail = new ActorDetail();
		 
		 List<Cast> cast = castBO.getCharacterName(movieId);
		 
		 actorDetail.setId(actor.getId()); 
		 actorDetail.setMoiveId(actor.getMovieId());
		 actorDetail.setActor(actor.getActor());
		 
		 ActorDetailList.add(actorDetail); }
		 
		 List<Cast> castList = castBO.getCharacterName(movieId);
		 
		 for(Cast cast:castList) { ActorDetail castdetail = new ActorDetail();
		 
		 castdetail.setCharactername(cast.getCharactername());
		 
		 ActorDetailList.add(castdetail); }
*/		 

		for (int i = 0; i < actorList.size(); i++) {
			ActorDetail actorDetail = new ActorDetail();
			
			actorDetail.setId(actorList.get(i).getId());
			actorDetail.setMoiveId(actorList.get(i).getMovieId());
			actorDetail.setActor(actorList.get(i).getActor());
			actorDetail.setCharactername(castList.get(i).getCharactername());
			ActorDetailList.add(actorDetail);
		}

		return ActorDetailList;
	}

}
