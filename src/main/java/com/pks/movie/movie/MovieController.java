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
import com.pks.movie.actor.model.ActorDetail;
import com.pks.movie.cast.bo.CastBO;
import com.pks.movie.cast.model.Cast;
import com.pks.movie.famousline.bo.FamouslineBO;
import com.pks.movie.famousline.model.Famousline;
import com.pks.movie.famousline.model.FamouslineDetail;
import com.pks.movie.movie.bo.MovieBO;
import com.pks.movie.movie.model.Movie;
import com.pks.movie.movie.model.MovieDetail;
import com.pks.movie.user.bo.UserBO;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieBO movieBO;
	
	@Autowired 
	private ActorBO actorBO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private FamouslineBO famouslineBO;
	
	@Autowired
	private CastBO castBO;
	
	
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
			, @RequestParam("val") int val
			, Model model) {
		
		MovieDetail movie = movieBO.getMoiveById(movieId);
		Actor actor = actorBO.getActorByMovieId(movieId);
		List<ActorDetail> actorDetail = actorBO.getActorDetailList(movieId);
		List<Famousline> famouslineList  = famouslineBO.selectFamousLine(movieId);
		List<Cast> castList = castBO.getCharacterName(movieId);
		List<FamouslineDetail> famouslineDetailList = actorBO.getFamouslineDetailList(movieId);
		
		model.addAttribute("movie", movie);
		model.addAttribute("actor", actor);
		model.addAttribute("actorDetail", actorDetail);
		model.addAttribute("famouslineList", famouslineList);

		model.addAttribute("famouslineDetailList" , famouslineDetailList);
		
		List<Actor> actorList = actorBO.getActorList(movieId);
		
		model.addAttribute("actorList", actorList);
		
		return "/movie/moviedetail";
	}
	
	

	

}
