package com.springCareer.service;

import java.util.List;


import com.springCareer.domain.FreeBoardLikeVO;
import com.springCareer.domain.FreeBoardReplyVO;
import com.springCareer.domain.FreeBoardVO;


public interface FreeLikeService {
	
	public List<FreeBoardLikeVO> getList(Long post_id); //배열로 들고옴
	
	public void likeUp(Long post_id, String userId);
	
	public boolean likeDown(Long post_id, String userId);
	
	public int likeCount(Long post_id);

	public int findLike(Long post_id, String userId);
	

}