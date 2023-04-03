package com.pks.movie.famousline.bo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.actor.bo.ActorBO;
import com.pks.movie.actor.model.Actor;
import com.pks.movie.cast.bo.CastBO;
import com.pks.movie.cast.model.Cast;
import com.pks.movie.famousline.dao.FamouslineDAO;
import com.pks.movie.famousline.model.Famousline;
import com.pks.movie.famousline.model.FamouslineDetail;
import com.pks.movie.like.bo.LikeBO;
import com.pks.movie.user.bo.UserBO;
import com.pks.movie.user.model.User;

@Service
public class FamouslineBO {
	
	@Autowired
	private FamouslineDAO famouslineDAO;
	
	@Autowired
	private CastBO castBO;
	
	@Autowired
	private ActorBO actorBO;
	
	@Autowired
	private UserBO userBO;

	@Autowired
	private LikeBO likeBO;
	
	
	
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
	
	public List<FamouslineDetail> getFamouslineDetailList(int movieId){
		
		List<Famousline> famouslineList = famouslineDAO.selectFamousLine(movieId);
		
		List<FamouslineDetail> famouslineDetailList = new ArrayList<>();	
		
		
		for(Famousline famousline:famouslineList) {
			FamouslineDetail famouslineDetail = new FamouslineDetail();
			
			Cast castList =  castBO.getCharacterName1(famousline.getCastingId());
			
			Actor actorList = actorBO.getActorByMovieId(castList.getActorId());
			
			User userList = userBO.selectUserById(famousline.getUserId());
			
//			Like likeList = likeBO.selectLike(famousline.getId());
			int like = likeBO.likeCount(famousline.getId(), 1);
			
			
			boolean isLike = likeBO.isLike(famousline.getUserId(), famousline.getId(), 1);
			
			
			famouslineDetail.setId(famousline.getId());
			famouslineDetail.setUserId(famousline.getUserId());
			famouslineDetail.setMovieId(famousline.getMoiveId());
			famouslineDetail.setActorId(famousline.getActorId());
			famouslineDetail.setCastingId(famousline.getCastingId());
			famouslineDetail.setFamousline(famousline.getFamousline());
			famouslineDetail.setExplain(famousline.getExplain());
			famouslineDetail.setCreatedAt(famousline.getCreatedAt());
			
				
			famouslineDetail.setCharactername(castList.getCharactername());
			famouslineDetail.setActor(actorList.getActor());
			famouslineDetail.setImagePath(actorList.getImagePath());
			famouslineDetail.setNickname(userList.getNickname());
			famouslineDetail.setLike(isLike);
			famouslineDetail.setLikeCount(like);
			
			
			famouslineDetailList.add(famouslineDetail);

			
		}
		
		return famouslineDetailList;
	}
	
	public int countFamouslineByMovieId(int movieId) {
		return famouslineDAO.countFamouslineByMovieId(movieId);
	}
	
}
