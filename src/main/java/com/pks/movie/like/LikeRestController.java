package com.pks.movie.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.movie.like.bo.LikeBO;

@RestController
public class LikeRestController {

	@Autowired
	private LikeBO likeBO;
	
	
	@PostMapping("/like")
	public Map<String, String> like(
			@RequestParam("famouslineId") int famouslineId
			, @RequestParam("divisionId") int divisionId
			, HttpSession session){
		
		Map<String, String> result = new HashMap<>();
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = likeBO.addLike(userId, famouslineId, divisionId);
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
}
