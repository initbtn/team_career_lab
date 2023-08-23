package com.springCareer.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springCareer.domain.UserVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(classes = { com.springCareer.config.RootConfig.class })
@Log4j
public class UserMapperTest {

	@Setter(onMethod_ = @Autowired)
	private UserMapper mapper;

//	@Test
	public void testGetList() {
		mapper.getUserList().forEach(user -> log.info(user));
	}

//	@Test
	public void testInsert() {
		UserVO user = new UserVO();
		user.setUserId("3333");
		user.setUserPassword("3333");
		user.setUserNickname("Kim");
		user.setUserAddress("1111");
		user.setUserEmail("1111");
		user.setUserName("kim");
		user.setUserPhone("0000");
		mapper.insertUser(user);

		log.info(user);
	}

//	@Test
	public void testRead() {
//		UserVO user = new UserVO();
		UserVO user = mapper.readUser("2222");
		System.out.println("확인용 : " + user);
		log.info(user);
	}

//	@Test
	public void testCheckId() {
		log.info(mapper.checkUserId("111"));
//		System.out.println("확인용 : " + mapper.checkUserId("111"));
//		System.out.println("확인용 : " + mapper.checkUserId("111"));
	}

//	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.deleteUser("1111"));
		int n = mapper.deleteUser("3333");
		System.out.println(n);
	}

//	@Test
	public void testUpdate() {
		UserVO user = new UserVO();

		user.setUserId("1111");
		user.setUserPassword("1515");
		user.setUserName("홍길동");
		user.setUserEmail("1");
		user.setUserNickname("수정된 내용");
		user.setUserAddress("1");
		user.setUserPhone("00");

		int count = mapper.updateUser(user);
		log.info("UPDATE COUNT: " + count);
	}

}
