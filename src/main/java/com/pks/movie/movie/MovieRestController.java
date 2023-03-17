package com.pks.movie.movie;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pks.movie.movie.bo.MovieBO;

@RestController
@RequestMapping("/movie")
public class MovieRestController {
	
	@Autowired
	private MovieBO  movieBO;
	
	
	@PostMapping("/upload")
	public Map<String, String> uploadMovie(
			@RequestParam("movietitle") String movietitle
			, @RequestParam("genre")  String genre
			, @RequestParam("country") String country
			, @RequestParam("releasedate") String releasedate
			, @RequestParam("director") String director
			, @RequestParam("file") MultipartFile file
			, @RequestParam("story") String story){
		
		int count = movieBO.addMovie(movietitle, genre, country, releasedate, director, file, story);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@PostMapping("/audience/update")
	public Map<String, String> updateAudience(
			@RequestParam("movieId") int movieId
			, @RequestParam("audience") int audience){
		int count = movieBO.updateAudience(movieId, audience);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}
		
	
	@PostMapping("/delete")
	public Map<String, String> deleteMovie(
			@RequestParam("movieId") int movieId){
		
		int count = movieBO.deleteMovie(movieId);
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}
	
	/*
	 * public String moiveListview(Model model) { List<Movie> movieList =
	 * movieBO.getMovieList();
	 * 
	 * model.addAttribute("movieList" ,movieList);
	 * 
	 * return "";
	 * 
	 * }
	 */
	


}
