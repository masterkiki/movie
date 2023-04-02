package com.pks.movie.movie;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.pks.movie.review.bo.ReviewBO;
import com.pks.movie.review.model.ReviewDetail;
import com.pks.movie.review.model.ReviewHome;
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
	
	@Autowired
	private ReviewBO reviewBO;
	
	@GetMapping("/home/view")
	public String moivehomeview(Model model) {
		
		List<ReviewHome> reviewHomeList = reviewBO.getReviewDetailById();
		List<Movie> movieList = movieBO.getMovieList();
		
		model.addAttribute("movieList" ,movieList);
		model.addAttribute("reviewHomeList" ,reviewHomeList);
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
			, Model model
			, HttpSession session) {
		
		MovieDetail movie = movieBO.getMoiveById(movieId);
		Actor actor = actorBO.getActorByMovieId(movieId);
		List<ActorDetail> actorDetail = actorBO.getActorDetailList(movieId);
		List<Famousline> famouslineList  = famouslineBO.selectFamousLine(movieId);
		List<Cast> castList = castBO.getCharacterName(movieId);
		List<FamouslineDetail> famouslineDetailList = famouslineBO.getFamouslineDetailList(movieId);
		List<ReviewDetail> reviewDetailList = reviewBO.getReviewDetailList(movieId);
		
		int count = famouslineBO.countFamouslineByMovieId(movieId);
		
		model.addAttribute("movie", movie);
		model.addAttribute("actor", actor);
		model.addAttribute("actorDetail", actorDetail);
		model.addAttribute("famouslineList", famouslineList);
		model.addAttribute("famouslineDetailList" , famouslineDetailList);
		model.addAttribute("reviewDetailList" ,reviewDetailList);
		
		
		List<Actor> actorList = actorBO.getActorList(movieId);
		
		model.addAttribute("actorList", actorList);
//		model.addAttribute("ff", count);
		// 굳이 이걸 안써도 jstl 통해서 리스트 사이즈를 알아올수있는 기능이있어 그것으로 처리함
		// 만약 위의 ff로 사용하려면 count 자체가 값이므로 ${ff.(값)} 안하고 ${ff} 만써도 값이 나온다
		
		return "/movie/moviedetail";
	}
	
	

	

}
