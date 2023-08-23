package com.springCareer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springCareer.domain.FreeBoardLikeVO;
import com.springCareer.domain.FreeBoardReplyVO;
import com.springCareer.domain.FreeBoardVO;
import com.springCareer.mapper.FreeLikeMapper;
import com.springCareer.mapper.FreeReplyMapper;

import lombok.AllArgsConstructor;
//import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class FreeLikeServiceImpl implements FreeLikeService {
	//@Setter(onMethod_ = @Autowired) 대신 -> @AllArgsConstructor
	private FreeLikeMapper mapper;
	 

	@Override
	public void likeUp(Long post_id, String userId) {
		FreeBoardLikeVO up = new FreeBoardLikeVO();
		up.setPost_id(post_id);
		up.setUserId(userId);
		mapper.likeUp(up);
		
	}

	@Override
	public int likeCount(Long post_id) {
		log.info("게시글"+post_id+"의 좋아요 갯수를 위한것");
		return mapper.likeCount(post_id);
	}

	@Override
	public int findLike(Long post_id, String userId) {
		FreeBoardLikeVO like = new FreeBoardLikeVO();
		like.setPost_id(post_id);
		like.setUserId(userId);
		return mapper.findLike(like);
	}

	@Override
	public boolean likeDown(Long post_id, String userId) {
		FreeBoardLikeVO cancle = new FreeBoardLikeVO();
		cancle.setPost_id(post_id);
		cancle.setUserId(userId);
		log.info("좋아요 내리기......post_id: "+post_id+", and userId :"+userId);
		return mapper.likeDown(cancle) == 1;
		
	}

	@Override
	public List<FreeBoardLikeVO> getList(Long post_id) {
		log.info("getList......");
		return mapper.getList(post_id);
	}
	
	

}
