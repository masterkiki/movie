package com.pks.movie.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.movie.review.bo.ReviewBO;
import com.pks.movie.review.model.Review;

@RestController
@RequestMapping("/review")
public class ReviewRestController {

	@Autowired
	private ReviewBO reviewBO;
	
	
	@GetMapping("/add")
	public Map<String, String> addReview(
			@RequestParam("movieId") int movieId
			, @RequestParam("review") String review
			, @RequestParam("point") int point
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = reviewBO.addReview(userId, movieId, review, point);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}
	
	
}
