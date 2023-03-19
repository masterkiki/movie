package com.pks.movie.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pks.movie.actor.bo.ActorBO;
import com.pks.movie.actor.model.Actor;

@Controller
public class ActorController {

	/*
	 * @Autowired private ActorBO actorBO;
	 * 
	 * @PostMapping("/actor/list") public String actorListBtmovieId(
	 * 
	 * @RequestParam("moiveId") int movieId , Model model) {
	 * 
	 * Actor actor = actorBO.getActorByMovieId(movieId);
	 * 
	 * model.addAttribute("actorList", actor);
	 * 
	 * 
	 * return "/cast/manager/view"; }
	 */
	
}
