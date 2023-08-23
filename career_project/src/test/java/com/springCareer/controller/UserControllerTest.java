package com.springCareer.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { com.springCareer.config.RootConfig.class,
		com.springCareer.config.ServletConfig.class })
@Log4j
public class UserControllerTest {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

//	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/user/register").param("userId", "7777")
						.param("userPassword", "Test").param("userName", "user11").param("userEmail", "user@naver.com")
						.param("userNickname", "1111").param("userAddress", "user").param("userPhone", "00"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}

//	@Test
	public void testLogin() throws Exception {
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/user/login").param("userId", "1111").param("userPassword", "12111"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}

//	@Test
	public void testIdCheck() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/user/idcheck").param("userId", "11")).andReturn()
				.getModelAndView().getModelMap());

	}

//	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/user/modify").param("userId", "1111")
						.param("userPassword", "1111").param("userName", "user11").param("userEmail", "user@naver.com")
						.param("userNickname", "두번째 닉네임").param("userAddress", "user").param("userPhone", "새번호"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}

//	@Test
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/user/remove").param("userId", "7777"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}

}
