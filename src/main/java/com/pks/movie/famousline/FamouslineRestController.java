package com.pks.movie.famousline;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.movie.famousline.bo.FamouslineBO;

@RestController
@RequestMapping("/famousline")
public class FamouslineRestController {

	@Autowired
	private FamouslineBO famouslineBO;
	
	
	@PostMapping("/add")
	public Map<String, String> addFamousLine(
			@RequestParam("movieId") int movieId
			, @RequestParam("actorId") int acotrId
			, @RequestParam("castingId") int castingId
			, @RequestParam("famousline") String famousline
			, @RequestParam("explain") String explain
			, HttpSession session){
		
		Map<String, String> result = new HashMap<>();
		int userId = (Integer)session.getAttribute("userId");

		
//		if(session.getAttribute("userId") == null) {
//			result.put("login", "fail");
//		} else {
			
		int count = famouslineBO.addFamousLine(userId, movieId, acotrId, castingId, famousline, explain);
			
		if(count == 1) {
				result.put("result", "success");
		} else {
				result.put("result", "fail");
		}
			
//		}
		

		
	
		return result;
	
	}
	
}
