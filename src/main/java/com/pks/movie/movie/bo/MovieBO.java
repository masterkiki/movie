package com.pks.movie.movie.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pks.movie.common.FileManagerService;
import com.pks.movie.movie.dao.MovieDAO;
import com.pks.movie.movie.model.Movie;
import com.pks.movie.movie.model.MovieDetail;

@Service
public class MovieBO {
	
	@Autowired
	private MovieDAO movieDAO;

	public int addMovie(
			String movietitle
			, String genre
			, String country
			, String releasedate
			, String director
			, MultipartFile file
			, String story) {
		
		String imagePath = FileManagerService.saveFile(movietitle, file);
		
		return movieDAO.addMovie(movietitle, genre, country, releasedate, director, imagePath, story);
	}
	
	
	public List<Movie> getMovieList() {
		return movieDAO.selectMovie();
	}
	
	public int updateAudience(
			int movieId
			, int audience) {
		return movieDAO.updateAudience(movieId, audience);
	}
	
	
	public MovieDetail getMoiveById(int movieId) {
		 return movieDAO.selectMovieById(movieId);
	}
	
	
	public int deleteMovie(int movieId) {
		return movieDAO.deleteMovie(movieId);
	}
	
	public Movie getMovieList1(int id) {
		return movieDAO.selectMovie1(id);
	}
	
	
	
}
