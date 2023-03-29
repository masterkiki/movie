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
import com.pks.movie.famousline.bo.FamouslineBO;
import com.pks.movie.famousline.model.Famousline;
import com.pks.movie.famousline.model.FamouslineDetail;

@Service
public class ActorBO {

	@Autowired
	private ActorDAO actorDAO;

	@Autowired
	private CastBO castBO;
	
	@Autowired
	private FamouslineBO famouslineBO;

	public int addActor(
			int movieId
			, String actor
			, MultipartFile file) {

		String imagePath = FileManagerService.saveFileActor(actor, file);
		
		return actorDAO.addActor(movieId, actor, imagePath);

	}

	public Actor getActorByMovieId(int movieId) {
		return actorDAO.selectActorByMovieId(movieId);
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

		List<Cast> castList = castBO.getCharacterName(movieId);
	
		List<Famousline> famouslineList = famouslineBO.selectFamousLine(movieId);
		
		for (int i = 0; i < actorList.size(); i++) {
			ActorDetail actorDetail = new ActorDetail();
			
			actorDetail.setId(actorList.get(i).getId());
			actorDetail.setMoiveId(actorList.get(i).getMovieId());
			actorDetail.setActor(actorList.get(i).getActor());
			actorDetail.setImagePath(actorList.get(i).getImagePath());
			for(int j =0; j < castList.size(); j++) {
				actorDetail.setActorId(castList.get(i).getActorId());
				if(actorList.get(i).getId() == castList.get(j).getActorId()) {
					actorDetail.setCastingId(castList.get(j).getId());
					actorDetail.setCharactername(castList.get(j).getCharactername());
//					for(int k = 0; k < famouslineList.size(); k++) {
//						if(castList.get(j).getId() == famouslineList.get(k).getCastingId()) {
//							actorDetail.setFamouslineId(famouslineList.get(k).getId());
//							actorDetail.setFamousline(famouslineList.get(k).getFamousline());
//						}
//					}
					ActorDetailList.add(actorDetail);
				}
			}
			
			
		}

		return ActorDetailList;
	}

}
