package com.pks.movie.famousline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.cast.bo.CastBO;
import com.pks.movie.cast.model.Cast;
import com.pks.movie.famousline.dao.FamouslineDAO;
import com.pks.movie.famousline.model.Famousline;
import com.pks.movie.famousline.model.FamouslineDetail;

@Service
public class FamouslineBO {
	
	@Autowired
	private FamouslineDAO famouslineDAO;
	
	@Autowired
	private CastBO castBO;
	

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
			
			famouslineDetail.setId(famousline.getId());
			famouslineDetail.setUserId(famousline.getUserId());
			famouslineDetail.setMovieId(famousline.getMoiveId());
			famouslineDetail.setActorId(famousline.getActorId());
			famouslineDetail.setCastingId(famousline.getCastingId());
			famouslineDetail.setFamousline(famousline.getFamousline());
			famouslineDetail.setExplain(famousline.getExplain());
			
			Cast castList =  castBO.getCharacterName1(movieId);
		
			if(famousline.getCastingId() == castList.getId()) {
				famouslineDetail.setCharactername(castList.getCharactername());
				
			}
			famouslineDetailList.add(famouslineDetail);

			
		}
		
		return famouslineDetailList;
	}
	
}
