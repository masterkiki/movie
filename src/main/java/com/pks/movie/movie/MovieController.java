package com.pks.movie.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pks.movie.movie.bo.MovieBO;
import com.pks.movie.movie.model.Movie;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieBO movieBO;
	
	
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
		Movie movie = movieBO.getMoiveById(movieId);
		
		model.addAttribute("movie", movie);
		
		return "/movie/moviedetail";
	}
	
}
