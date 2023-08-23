package com.springCareer.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springCareer.domain.CareerBoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.springCareer.config.RootConfig.class })
@Log4j
public class CareerBoardMapperTest {

	@Setter(onMethod_ = @Autowired)
	private CareerBoardMapper mapper;

//	@Test
	public void testGetList() {
		mapper.getCareerList().forEach(career -> log.info(career));
	}

//	@Test
	public void testreads() {
//		mapper.readCareerList("2222").forEach(career -> log.info(career));
		List<CareerBoardVO> career = mapper.readCareerList("2222");
		log.info(career);
	}

//	@Test
	public void testread() {
		CareerBoardVO career = mapper.readCareer("1111");
		log.info(career);
	}

//	@Test
	public void testInsert() {
		CareerBoardVO career = new CareerBoardVO();
		for (int i = 0; i < 10; i++) {
			career.setUserId("1111");
			career.setPrIntro("111"+i+" 자기소개입니다.");
			career.setPrPic("111" + i);
			mapper.insertCareer(career);

			log.info(career);
		}
	}

//	@Test
	public void testUpdate() {

		CareerBoardVO career = new CareerBoardVO();
		career.setCrbId(1L);
		career.setUserId("2222");
		career.setPrIntro("업데이트 테스트용입니다.");
		career.setPrPic("업데이트 자기소개입니다.");
		mapper.updateCareer(career);
		log.info(career);
	}

//	@Test
	public void testDelete() {
		log.info("DELETE : " + mapper.deleteCareer(2L));

	}

}
