package com.pks.movie.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pks.movie.actor.bo.ActorBO;
import com.pks.movie.actor.model.Actor;
import com.pks.movie.movie.bo.MovieBO;
import com.pks.movie.movie.model.Movie;
import com.pks.movie.movie.model.MovieDetail;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieBO movieBO;
	
	@Autowired ActorBO actorBO;
	
	
	@GetMapping("/home/view")
	public String moivehomeview(Model model) {
		
		List<Movie> movieList = movieBO.getMovieList();
		
		model.addAttribute("movieList" ,movieList);
		return "/movie/moviehome";
	}
	
	@GetMapping("/admin/upload/view")
	public String moiveupload() {
		return "/admin/upload";
	}
	
	@GetMapping("/admin/movielist/view")
	public String moiveList(Model model) {
		List<Movie> movieList = movieBO.getMovieList();
		
		
		model.addAttribute("movieList" ,movieList);
		return "/admin/movielist";
	}

	

	
	
	@GetMapping("/detail/view")
	public String movieInfoView(
			@RequestParam("movieId") int movieId			
			,Model model) {
		MovieDetail movie = movieBO.getMoiveById(movieId);
		Actor actor = actorBO.getActorByMovieId(movieId);
		
		model.addAttribute("movie", movie);
		model.addAttribute("actor", actor);
		List<Actor> actorList = actorBO.getActorList(movieId);
		
		model.addAttribute("actorList", actorList);
		return "/movie/moviedetail";
	}
	

}
