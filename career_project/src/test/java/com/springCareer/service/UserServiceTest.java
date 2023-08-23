package com.springCareer.service;

import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpSession;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springCareer.domain.UserVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.springCareer.config.RootConfig.class })
@Log4j
public class UserServiceTest {

	@Autowired
	private UserService service;

//	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}

//	@Test
	public void testCheckid() {
		log.info(service.checkUserId("3333"));
	}

//	@Test
	public void testRegister() {
		UserVO user = new UserVO();
		HttpSession session = null;
//		for (int i = 0; i < 10; i++) {
//			user.setUserId("111" + i);
//			user.setUserPassword("111" + i);
//			user.setUserEmail(i + "123@123" + i);
//			user.setUserName("kkk");
//			user.setUserNickname("kkk");
//			user.setUserAddress("1111");
//			user.setUserPhone("0000");
//			service.registerUser(user);
//			log.info("생성된 유저 아이디 : " + user.getUserId());
//		}
		user.setUserId("111");
		user.setUserPassword("111");
		user.setUserEmail("123@123");
		user.setUserName("kkk");
		user.setUserNickname("kkk");
		user.setUserAddress("1111");
		user.setUserPhone("0000");

		service.registerUser(user, session);
		log.info("생성된 유저 아이디 : " + user.getUserId());
	}

//	@Test
	public void testGetList() {
		service.getList().forEach(user -> log.info(user));
	}

//	@Test
	public void testGet() {
		log.info(service.getUser("111"));
	}

//	@Test
	public void testDelete() {
		log.info("REMOVE RESULT: " + service.removeUser("111"));
	}

//	@Test
	public void testUpdate() {
		UserVO user = service.getUser("5555");
		if (user == null) {
			return;
		}
		log.info("MODIFY RESULT: " + service.modifyUser(user));
	}

}
