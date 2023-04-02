package com.pks.movie.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.movie.like.bo.LikeBO;

@RestController
@RequestMapping("/like")
public class LikeRestController {

	@Autowired
	private LikeBO likeBO;
	
	
	@GetMapping("/like")
	public Map<String, String> like(
			@RequestParam("rowId") int rowId
			, @RequestParam("divisionId") int divisionId
			, HttpSession session){
		
		Map<String, String> result = new HashMap<>();
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = likeBO.addLike(userId, rowId, divisionId);
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
	@GetMapping("/unlike")
	public Map<String, String> unlike(
			@RequestParam("rowId") int rowId
			, @RequestParam("divisionId") int divisionId
			, HttpSession session){
		
		Map<String, String> result = new HashMap<>();
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = likeBO.addLike(userId, rowId, divisionId);
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
}
