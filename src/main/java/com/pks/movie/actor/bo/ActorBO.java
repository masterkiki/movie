package com.pks.movie.actor.bo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.actor.dao.ActorDAO;
import com.pks.movie.actor.model.Actor;
import com.pks.movie.actor.model.ActorDetail;
import com.pks.movie.cast.bo.CastBO;
import com.pks.movie.cast.model.Cast;
import com.pks.movie.famousline.bo.FamouslineBO;
import com.pks.movie.famousline.model.Famousline;

@Service
public class ActorBO {

	@Autowired
	private ActorDAO actorDAO;

	@Autowired
	private CastBO castBO;
	
	@Autowired
	private FamouslineBO famouslineBO;

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
		
		List<Famousline> famouslineList = famouslineBO.selectFamousLine(movieId);

		
		for (int i = 0; i < actorList.size(); i++) {
			ActorDetail actorDetail = new ActorDetail();
			
			actorDetail.setId(actorList.get(i).getId());
			actorDetail.setMoiveId(actorList.get(i).getMovieId());
			actorDetail.setActor(actorList.get(i).getActor());
			for(int j =0; j < castList.size(); j++) {
				actorDetail.setActorId(castList.get(i).getActorId());
				if(actorList.get(i).getId() == castList.get(j).getActorId()) {
					actorDetail.setCharactername(castList.get(j).getCharactername());
					actorDetail.setCastingId(castList.get(j).getId());
					for(int k = 0; k < famouslineList.size(); k++) {
						if(castList.get(j).getId() == famouslineList.get(k).getCastingId()) {
							
							actorDetail.setFamouslineId(famouslineList.get(k).getId());
							actorDetail.setFamousline(famouslineList.get(k).getFamousline());
						}
					}
				}
			}
			
			ActorDetailList.add(actorDetail);
			
		}

		return ActorDetailList;
	}

}
