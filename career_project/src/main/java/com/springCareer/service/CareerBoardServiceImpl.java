package com.springCareer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springCareer.domain.CareerBoardVO;
import com.springCareer.domain.FreeBoardVO;
import com.springCareer.mapper.CareerBoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class CareerBoardServiceImpl implements CareerBoardService {

	private CareerBoardMapper mapper;

	@Override
	public void registerCareer(CareerBoardVO career) {
		// TODO Auto-generated method stub
		log.info("커리어 등록 -> " + career);
		mapper.insertCareer(career);
	}

	@Override
	public List<CareerBoardVO> getList() {
		log.info("커리어 리스트 -> ");
		return mapper.getCareerList();
	}

	@Override
	public List<CareerBoardVO> getCareerList(String userId) {
		// TODO Auto-generated method stub
		log.info("회원의 커리어 리스트 -> " + userId);
		return mapper.readCareerList(userId);
	}

	@Override
	public CareerBoardVO getCareer(String userId) {
		// TODO Auto-generated method stub
		log.info("조회 -> " + userId);
		return mapper.readCareer(userId);
	}

	@Override
	public boolean modifyCareer(CareerBoardVO career) {
		// TODO Auto-generated method stub

		return mapper.updateCareer(career) == 1;
	}

	@Override
	public boolean deleteCareer(Long crbId) {
		// TODO Auto-generated method stub

		return mapper.deleteCareer(crbId) == 1;
	}
	
	@Override
	public List<FreeBoardVO> getMyBoard(String userId) {
		// TODO Auto-generated method stub
		return mapper.getMyBoard(userId);
	}

}
