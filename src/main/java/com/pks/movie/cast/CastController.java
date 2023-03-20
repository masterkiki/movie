package com.pks.movie.cast;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pks.movie.actor.bo.ActorBO;
import com.pks.movie.actor.model.Actor;
import com.pks.movie.cast.bo.CastBO;
import com.pks.movie.cast.model.Cast;
import com.pks.movie.movie.bo.MovieBO;
import com.pks.movie.movie.model.Movie;

@Controller
@RequestMapping("/cast")
public class CastController {
	
	@Autowired
	private ActorBO actorBO;
	
	@Autowired
	private MovieBO movieBO;
	
	@Autowired
	private CastBO castBO;
	
	
	@GetMapping("/manager/view")
	public String actorcastManagerView(
			@RequestParam("movieId") int movieId
			,Model model) {
		
		List<Movie> movie = movieBO.getMovieList();
		List<Actor> actor = actorBO.getActorList(movieId);
		List<Cast> castList = castBO.getCharacterName(movieId);
		
		
		model.addAttribute("movieList", movie);
		model.addAttribute("castList",castList);
		model.addAttribute("actorList", actor);
		
		return "/admin/actorcastmanager";
	}
	
	

}
