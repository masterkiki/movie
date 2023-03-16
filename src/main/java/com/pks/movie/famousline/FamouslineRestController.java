package com.pks.movie.famousline;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.movie.famousline.bo.FamouslineBO;

@RestController
@RequestMapping("/famousline")
public class FamouslineRestController {

	@Autowired
	private FamouslineBO famouslineBO;
	
	
	@PostMapping("/add")
	public Map<String, String> addFamousLine(
			@RequestParam("userId") int userId
			, @RequestParam("movieId") int movieId
			, @RequestParam("actorId") int acotrId
			, @RequestParam("famousline") String famousline
			, @RequestParam("explain") String explain
			, Model model){
		
		int count = famouslineBO.addFamousLine(userId, movieId, acotrId, famousline, explain);
		
		Map<String, String> result = new HashMap<>();
		model.addAttribute("user",userId);
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
	
		return result;
	
	}
	
}
