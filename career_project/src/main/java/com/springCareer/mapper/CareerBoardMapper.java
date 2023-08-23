package com.springCareer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springCareer.domain.CareerBoardVO;
import com.springCareer.domain.FreeBoardVO;

@Mapper
public interface CareerBoardMapper {

	public List<CareerBoardVO> getCareerList();

	public List<CareerBoardVO> readCareerList(String userId);
	
	public List<FreeBoardVO> getMyBoard(String userId);

	public CareerBoardVO readCareer(String userId);

	public void insertCareer(CareerBoardVO career);

	public int updateCareer(CareerBoardVO career);

	public int deleteCareer(Long crbId);

}
