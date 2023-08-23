package com.springCareer.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springCareer.domain.FreeBoardVO;
import com.springCareer.service.FreeBoardService;
import com.springCareer.service.FreeLikeService;
import com.springCareer.service.FreeReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class FreeBoardController {
	
	private FreeBoardService service;
	private FreeReplyService replyService;
	private FreeLikeService likeService;
	
	@GetMapping("/register")
	public void register() {
		
	}
		
	@GetMapping("/list")	//1. select 전체 list
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list",service.getList());
	}
	
//	@GetMapping("/list")
//	public void list(Criteria cri, Model model)
//	{
//		log.info("list: "+cri);
//		model.addAttribute("list", service.getList(cri));
//	}
	
	
	@PostMapping("/register")	//2.입력 insert
	public String register(FreeBoardVO board, RedirectAttributes rttr) {
		log.info("register: " + board);		
		service.register(board);
		rttr.addFlashAttribute("result", board.getPost_id());
		return "redirect:/board/list";
	}
	
//	@GetMapping("/get")		//3.검색 select
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("post_id") Long post_id, Model model, HttpSession session) { /*HttpServletRequest request, HttpServletResponse response) {*/
		log.info("/get");
		model.addAttribute("board", service.get(post_id));
		model.addAttribute("reply", replyService.getList(post_id));
		model.addAttribute("like", likeService.likeCount(post_id));
		model.addAttribute("check", replyService.getList(post_id));
		
		FreeBoardVO vo = service.get(post_id);
		
//		 Cookie oldCookie = null;
//		    Cookie[] cookies = request.getCookies();
//		    if (cookies != null) {
//		        for (Cookie cookie : cookies) {
//		            if (cookie.getName().equals("get")) {
//		                oldCookie = cookie;
//		            }
//		        }
//		    }
//
//		    if (oldCookie != null) {
//		        if (!oldCookie.getValue().contains("[" + post_id.toString() + "]")) {
//		        	service.hit(vo);
//		            oldCookie.setValue(oldCookie.getValue() + "_[" + post_id + "]");
//		            oldCookie.setPath("/");
//		            oldCookie.setMaxAge(60 * 60 * 24);
//		            response.addCookie(oldCookie);
//		        }
//		    } else {
//		    	service.hit(vo);
//		        Cookie newCookie = new Cookie("postView","[" + post_id + "]");
//		        newCookie.setPath("/");
//		        newCookie.setMaxAge(60 * 60 * 24);
//		        response.addCookie(newCookie);
//		    }
		service.hit(vo);
		log.info(post_id+"확인확인확인");
	    String userId = (String) session.getAttribute("userId");		
	    if(userId != null) {
	    model.addAttribute("likecheck", likeService.findLike(post_id, userId));
	    } else {
	    	model.addAttribute("likecheck", 0);
	    }
		
	}
	
	
	
	
	@PostMapping("/modify")		//4.수정
	public String modify(FreeBoardVO board, RedirectAttributes rttr) {
		log.info("modify:"+board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
//	@PostMapping("/remove")		//5.삭제
//	@GetMapping("/remove")		//5.삭제
	@RequestMapping(value="/remove", method= {RequestMethod.GET, RequestMethod.POST})
	public String remove(@RequestParam("post_id") Long post_id, RedirectAttributes rttr) {
		log.info("remove..."+post_id);
		if(service.remove(post_id)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
	
}
