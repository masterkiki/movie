package com.pks.movie.movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

	
	@GetMapping("/home/view")
	public String moivehomeview() {
		return "/movie/moviehome";
	}
	
	@GetMapping("/upload/view")
	public String moiveupload() {
		return "/admin/upload";
	}
	
}
