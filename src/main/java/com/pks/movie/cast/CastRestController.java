package com.pks.movie.cast;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.movie.cast.bo.CastBO;

@RestController
public class CastRestController {
	
	@Autowired
	private CastBO castBO;
	
	@PostMapping("/castname/add")
	public Map<String, String> addCast(
			@RequestParam("movieId") int movieId
			, @RequestParam("actorId") int actorId
			, @RequestParam("charactername") String charactername){
		
		int count = castBO.addCast(movieId, actorId, charactername);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}

}
