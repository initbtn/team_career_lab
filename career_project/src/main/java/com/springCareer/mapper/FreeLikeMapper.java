package com.springCareer.mapper;

import java.util.List;

import com.springCareer.domain.FreeBoardLikeVO;

public interface FreeLikeMapper {
	
	public List<FreeBoardLikeVO> getList(Long post_id); 

	public void likeUp(FreeBoardLikeVO up);
	
	public int likeDown(FreeBoardLikeVO cancle);
	
	public int likeCount(Long post_id);

	public int findLike(FreeBoardLikeVO like);

	public int delete(Long post_id);

}
