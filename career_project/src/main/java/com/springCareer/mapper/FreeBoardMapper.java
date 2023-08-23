package com.springCareer.mapper;

import java.util.List;

import com.springCareer.domain.Criteria;
import com.springCareer.domain.FreeBoardVO;


public interface FreeBoardMapper {
	/* @Select("select * from tbl_board where post_id>0") */
	public List<FreeBoardVO> getList(); //리스트 하나씩 보여주는것
	
	public List<FreeBoardVO> getListWithPaging(Criteria cri); //한페이지에 몇개씩 보이게 할건지

	public void insert(FreeBoardVO board);
	
	public Long getPostId(String userId);
	
	public FreeBoardVO read(Long post_id);
	
	public int delete(Long post_id);
	
	public int update(FreeBoardVO board);
	
	public int hit(FreeBoardVO board);
}
