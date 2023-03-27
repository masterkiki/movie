package com.pks.movie.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.movie.like.bo.LikeBO;

@RestController
public class LikeRestController {

	@Autowired
	private LikeBO likeBO;
	
	public Map<String, String> like(
			 @RequestParam("divisionId") int divisionId
			, @RequestParam("type") String type){
		
		Map<String, String> result = new HashMap<>();
		
		int count = likeBO.addLike(divisionId, divisionId, type);
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
}
