package com.springCareer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springCareer.domain.Criteria;
import com.springCareer.domain.FreeBoardReplyVO;


public interface FreeReplyMapper {
	/* @Select("select * from tbl_board where post_id>0") */
	public List<FreeBoardReplyVO> getList(Long post_id); //리스트 하나씩 보여주는것
	
//	public List<FreeBoardReplyVO> getListWithPaging(
//			@Param("cri") Criteria cri,
//			@Param("post_id") Long post_id);

	public void insert(FreeBoardReplyVO board);
	
	public FreeBoardReplyVO read(Long post_id);
	
	public int delete(Long comment_id);
	
	public int deleteReply(Long post_id);
	
	public int update(FreeBoardReplyVO board);
	
	public FreeBoardReplyVO replySelect(FreeBoardReplyVO vo);
}
