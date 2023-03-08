package com.pks.movie.movie.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pks.movie.common.FileManagerService;
import com.pks.movie.movie.dao.MovieDAO;

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
		
}
