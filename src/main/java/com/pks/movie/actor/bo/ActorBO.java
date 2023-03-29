package com.pks.movie.actor.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pks.movie.actor.dao.ActorDAO;
import com.pks.movie.actor.model.Actor;
import com.pks.movie.actor.model.ActorDetail;
import com.pks.movie.cast.bo.CastBO;
import com.pks.movie.cast.model.Cast;
import com.pks.movie.common.FileManagerService;

@Service
public class ActorBO {

	@Autowired
	private ActorDAO actorDAO;

	@Autowired
	private CastBO castBO;
	

	public int addActor(
			int movieId
			, String actor
			, MultipartFile file) {

		String imagePath = FileManagerService.saveFileActor(actor, file);
		
		return actorDAO.addActor(movieId, actor, imagePath);

	}

	public Actor getActorByMovieId(int actorId) {
		return actorDAO.selectActorByMovieId(actorId);
	}

	public List<Actor> getActorList(int movieId) {
		return actorDAO.selectActorList(movieId);
	}

	
//	public List<FamouslineDetail> getFamouslineDetailList(int movieId){
//		
//		List<Famousline> famouslineList = famouslineBO.selectFamousLine(movieId);
//		
//		List<FamouslineDetail> famouslineDetailList = new ArrayList<>();	
//		
//		for(Famousline famousline:famouslineList) {
//			FamouslineDetail famouslineDetail = new FamouslineDetail();
//			
//			famouslineDetail.setId(famousline.getId());
//			famouslineDetail.setUserId(famousline.getUserId());
//			famouslineDetail.setMovieId(famousline.getMoiveId());
//			famouslineDetail.setActorId(famousline.getActorId());
//			famouslineDetail.setCastinId(famousline.getCastingId());
//			famouslineDetail.setFamousline(famousline.getFamousline());
//			famouslineDetail.setExplain(famousline.getExplain());
//			
//			famouslineDetailList.add(famouslineDetail);
//		}
//		
//		return famouslineDetailList;
//	}
	
	
	
	
	public List<ActorDetail> getActorDetailList(int movieId) {

		List<Actor> actorList = actorDAO.selectActorList(movieId);

		List<ActorDetail> ActorDetailList = new ArrayList<>();

	
//		List<Famousline> famouslineList = famouslineBO.selectFamousLine(movieId);
		
		for (Actor actor:actorList) {
			Cast castList = castBO.getCharacterNameByActorId(actor.getId());
			ActorDetail actorDetail = new ActorDetail();
			
			actorDetail.setId(actor.getId());
			actorDetail.setMoiveId(actor.getMovieId());
			actorDetail.setActor(actor.getActor());
			actorDetail.setImagePath(actor.getImagePath());
			actorDetail.setCharactername(castList.getCharactername());
			actorDetail.setCastingId(castList.getId());
			
			ActorDetailList.add(actorDetail);
			}

		return ActorDetailList;
	}

}

//			for(int j =0; j < castList.size(); j++) {
//				actorDetail.setActorId(castList.get(i).getActorId());
//				if(actorList.get(i).getId() == castList.get(j).getActorId()) {
//					actorDetail.setCastingId(castList.get(j).getId());
//					actorDetail.setCharactername(castList.get(j).getCharactername());
//
//				}