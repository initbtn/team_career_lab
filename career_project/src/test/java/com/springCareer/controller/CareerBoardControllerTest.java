package com.springCareer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
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
public class CareerBoardControllerTest {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

//	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/career/register")
					.param("userId", "3333")
					.param("prIntro", "자기소개입니다.")
					.param("prPic", "1111"))
					.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
		
	}
	
	@Test
	public void testUpload() throws Exception{
		
		 MockMultipartFile file 
	      = new MockMultipartFile(
	        "file", 
	        "hello.txt", 
	        MediaType.TEXT_PLAIN_VALUE, 
	        "Hello, World!".getBytes()
	      );

	    MockMvc mockMvc 
	      = MockMvcBuilders.webAppContextSetup(ctx).build();
	    mockMvc.perform(multipart("/career/upload").file(file))
	      .andExpect(status().isOk());
		
	}

	
}
