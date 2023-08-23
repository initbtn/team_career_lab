package com.springCareer.service;

import java.util.List;


import com.springCareer.domain.FreeBoardReplyVO;


public interface FreeReplyService {
	
	public void register(FreeBoardReplyVO board); //c
	
	public FreeBoardReplyVO get(Long post_id); //r
		
	public boolean modify(FreeBoardReplyVO board); //u
	
	public boolean remove(Long comment_id); //dz
	
//	public List<FreeBoardReplyVO> getList(); //배열로 들고옴
	public List<FreeBoardReplyVO> getList(Long post_id); //배열로 들고옴
	
	public FreeBoardReplyVO replySelect(FreeBoardReplyVO vo);



}