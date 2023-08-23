package com.springCareer.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import com.springCareer.domain.CompanyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.springCareer.config.RootConfig.class})
@Log4j
public class CompanyMapperTest {

	@Setter(onMethod_= @Autowired)
	private CompanyMapper mapper;
	
//	@Test
	public void testGetList() {
		mapper.getList().forEach(company -> log.info(company));
//		System.out.println(mapper.getList());
	}
	
//	@Test
//	public void testInsert()
//	{
//		CompanyVO company = new CompanyVO();
//		company.setC_id("devMin");
//		company.setC_password("dev1234");
//		company.setC_name("디자인민");
//		company.setC_business_number("6068812312");
//		company.setC_phone("051-111-1234");
//		company.setC_email("dominic87@naver.com");
//		company.setC_address("부산 사하구 사하로141번길 63-2");
//		
//		mapper.insert(company);
//		
//		log.info(company);
//	}
//	
////	@Test
//	public void testRead()
//	{
//		// 존재하는 게시물 번호로 테스트
//		CompanyVO company = mapper.read("devMin");
//		
//		log.info(company);
//	}
//	
////	@Test
//	public void testDelete()
//	{
////		log.info("DELETE COUNT: " + mapper.delete(8L));
//		int n=mapper.delete("devMin");
//		System.out.println(n);
//	}
//	
////	@Test
//	public void testUpdate() {
//		
//		CompanyVO company = new CompanyVO();
//		// 실행 전 존재하는 번호인지 확인할 것
//		company.setC_id("minDev");
//		company.setC_password("min1234");
//		company.setC_name("민디");
//		company.setC_business_number("6068812312");
//		company.setC_phone("051-123-1004");
//		company.setC_email("dominic87@naver.com");
//		company.setC_address("부산 사하구 사하로141번길 63-2");
//		
//		int count = mapper.update(company);
//		log.info("UPDATE COUNT: " + count);
//	}
}
