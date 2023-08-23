package com.springCareer.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springCareer.domain.CareerBoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.springCareer.config.RootConfig.class })
@Log4j
public class CareerBoardServiceTest {

	@Autowired
	private CareerBoardService service;

//	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}

//	@Test
	public void testRegister() {
		CareerBoardVO career = new CareerBoardVO();
//		for (int i = 0; i < 10; i++) {
			
//			service.registerUser(user);
//			log.info("생성된 유저 아이디 : " + user.getUserId());
//		}
//		career.setPrIntro("자기소개입니다.");
//		career.setPrPic("사진입니다");
//		career.setUserId("4444");
//
//		service.registerCareer(career);

		log.info("생성된 커리어 아이디 : " + career.getCrbId());
	}

//	@Test
	public void testGetList() {
		service.getList().forEach(career -> log.info(career));
	}

//	@Test
	public void testGet() {
		log.info(service.getCareer("2222"));
	}

//	@Test
	public void testGetCareerList() {
		service.getCareerList("2222").forEach(career -> log.info(career));
	}

//	@Test
	public void testDelete() {
		log.info("REMOVE RESULT: " + service.deleteCareer(10L));
	}

//	@Test
	public void testUpdate() {
		CareerBoardVO career = service.getCareer("2222");
		log.info(career);
		if (career == null) {
			return;
		}
		log.info("MODIFY RESULT: " + service.modifyCareer(career));
	}

}
