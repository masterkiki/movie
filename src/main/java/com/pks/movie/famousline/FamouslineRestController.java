package com.pks.movie.famousline;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamouslineRestController {

	public Map<String, String> addFamousLine(
			@RequestParam("userId") int userId
			, @RequestParam("movieId") int movieId
			, @RequestParam("famousline") String famousline){
	
	}
	
}
