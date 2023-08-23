package com.springCareer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.springCareer.domain.FreeBoardReplyVO;
import com.springCareer.domain.FreeBoardVO;
import com.springCareer.service.FreeReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/reply/*")
@AllArgsConstructor
public class FreeReplyController {
	
	private FreeReplyService replyService;
	
	
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String register(FreeBoardReplyVO vo) throws Exception {
		 
		log.info(vo);
		replyService.register(vo);
		
		return "redirect:/board/get?post_id=" + vo.getPost_id();
	}
	
//	// 댓글 단일 조회 (수정 페이지)
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getMofidy(@RequestParam("post_id") Long post_id, @RequestParam("comment_id") Long comment_id, Model model) throws Exception {
	    
	    FreeBoardReplyVO vo = new FreeBoardReplyVO();
	    vo.setPost_id(post_id);
	    vo.setComment_id(comment_id);
	    
	    FreeBoardReplyVO reply1 = replyService.replySelect(vo);
	         
	    model.addAttribute("reply1", reply1);
	    
	}
	// 댓글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(FreeBoardReplyVO vo) throws Exception {

	    
		replyService.modify(vo);

	    return "redirect:/board/get?post_id=" + vo.getPost_id();
	}
	
	@RequestMapping(value="/remove", method= {RequestMethod.GET, RequestMethod.POST})
	public String remove(@RequestParam("comment_id") Long comment_id, @RequestParam("post_id") Long post_id, RedirectAttributes rttr) {
	    log.info("remove..."+comment_id);
	    
	    if(replyService.remove(comment_id)) {
	        rttr.addFlashAttribute("result", "success");
	    }
	    return "redirect:/board/get?post_id=" + post_id;
	}
	
}
