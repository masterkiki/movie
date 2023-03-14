package com.pks.movie.actor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pks.movie.actor.bo.ActorBO;

@RestController
public class ActorRestConroller {

	@Autowired
	private ActorBO actorBO;
	
	
	@PostMapping("/add/actor")
	public Map<String, String> addActor(
			@RequestParam("movieId") int movieId
			, @RequestParam("actor") String actor) {
	
		int count = actorBO.addActor(movieId, actor);
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
}
