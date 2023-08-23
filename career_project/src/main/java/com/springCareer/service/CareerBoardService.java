package com.springCareer.service;

import java.util.List;

import com.springCareer.domain.CareerBoardVO;
import com.springCareer.domain.FreeBoardVO;

public interface CareerBoardService {

	public void registerCareer(CareerBoardVO career);

	public List<CareerBoardVO> getList();

	public List<CareerBoardVO> getCareerList(String userId);
	
	public List<FreeBoardVO> getMyBoard(String userId);

	public CareerBoardVO getCareer(String userId);

	public boolean modifyCareer(CareerBoardVO career);

	public boolean deleteCareer(Long crbId);

}
