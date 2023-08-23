package com.springCareer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springCareer.domain.FollowVO;
import com.springCareer.service.FollowService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/follow/*")
@AllArgsConstructor
public class FollowController {

	private final FollowService followService;
	
	@PostMapping("/follow")
	@ResponseBody
	public String follow(@RequestParam("userId") String userId, HttpSession session, Model model) throws Exception{
		
		log.info("/follow : " + userId + "팔로우 요청");
		
		FollowVO follow = new FollowVO();
		follow.setFollowing(userId);
		follow.setFollower((String) session.getAttribute("userId"));
		
		followService.follow(follow);
		
		return "FollowOk";
	}
	
	@PostMapping("/unfollow")
	@ResponseBody
	public String unfollow(@RequestParam("userId") String usreId, HttpSession session, Model model) throws Exception{
		
		log.info("unfollow : " + usreId + "팔로우 취소");
		
		FollowVO follow = new FollowVO();
		
		follow.setFollowing(usreId);
		follow.setFollower((String) session.getAttribute("userId"));
		
		followService.unfollow(follow);
		
		return "unFollowOK";
	}
	
	@GetMapping("/get")
	public void getFollow(@RequestParam("userId")String userId, HttpSession session, Model model) {
		
		String userId2 = (String)session.getAttribute("userId");
		log.info("/get : " + userId + " : " + userId2);
		
		model.addAttribute("follower", followService.getFollower(userId));
		model.addAttribute("following", followService.getFollowing(userId2));
		model.addAttribute("followerList", followService.getFollowers(userId));
		model.addAttribute("followingList", followService.getFollowings(userId2));
		
	}
	
}






































