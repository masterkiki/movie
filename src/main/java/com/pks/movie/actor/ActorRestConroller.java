package com.pks.movie.actor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.movie.actor.bo.ActorBO;
import com.pks.movie.actor.model.Actor;

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
	
	@GetMapping("/actorlist")
	public List<Actor> actorList(@RequestParam("movieId") int movieId){
		
		 return actorBO.getActorList(movieId);
		
		
	}
	
	
}
