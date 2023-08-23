package com.springCareer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springCareer.domain.FreeBoardLikeVO;

import com.springCareer.service.FreeLikeService;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/like/*")
@AllArgsConstructor
public class FreeLikeController {
	
	private FreeLikeService service;
	
	
	@RequestMapping(value="/likeUp", method= {RequestMethod.GET, RequestMethod.POST})
	public String likeup(@RequestParam("userId") String userId, @RequestParam("post_id") Long post_id) throws Exception {
	    log.info("좋아요 넣기...");	
	    service.likeUp(post_id, userId);
	    
	    return "redirect:/board/get?post_id=" +post_id;
	}
	
	@RequestMapping(value="/likeDown", method= {RequestMethod.GET, RequestMethod.POST})
	public String likeDown(@RequestParam("userId") String userId, @RequestParam("post_id") Long post_id, RedirectAttributes rttr) {
	    if(service.likeDown(post_id, userId)) {
	        rttr.addFlashAttribute("result", "success");
	    }
	    return "redirect:/board/get?post_id=" + post_id;
	}		
		
	
}
