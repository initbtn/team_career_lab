package com.springCareer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springCareer.domain.FreeBoardReplyVO;

import com.springCareer.mapper.FreeReplyMapper;

import lombok.AllArgsConstructor;
//import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class FreeReplyServiceImpl implements FreeReplyService {
	//@Setter(onMethod_ = @Autowired) 대신 -> @AllArgsConstructor
	private FreeReplyMapper mapper;
	
	@Override //c
	public void register(FreeBoardReplyVO board) {
		log.info("register......" + board);
		mapper.insert(board);
	}

	@Override //r
	public FreeBoardReplyVO get(Long post_id) {
		log.info("get......" + post_id);
		return mapper.read(post_id);
	}
	

	@Override //u
	public boolean modify(FreeBoardReplyVO board) {
		log.info("modify......" + board);
		return mapper.update(board) == 1;
	}

	@Override //d
	public boolean remove(Long comment_id) {
		log.info("remove......" + comment_id);
		return mapper.delete(comment_id) == 1;
	}

	@Override
	public List<FreeBoardReplyVO> getList(Long post_id) {
		log.info("getList......");
		return mapper.getList(post_id);
	}
	
	@Override
	public FreeBoardReplyVO replySelect(FreeBoardReplyVO vo) {
		log.info("replySelect......" + vo);
		return mapper.replySelect(vo);
		
	}


}
