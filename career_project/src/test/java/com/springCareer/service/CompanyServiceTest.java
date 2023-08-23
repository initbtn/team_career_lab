package com.springCareer.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(classes = {com.springCareer.config.RootConfig.class})
@Log4j
public class CompanyServiceTest {

	@Setter(onMethod_ = { @Autowired })
	private CompanyService service;

//	@Test
	public void testExist() {

//		log.info(service);
//		assertNotNull(service);
	}

//	@Test
	public void testRegister() {
//
//		BoardVO board = new BoardVO();
//		board.setTitle("���� �ۼ��ϴ� ��");
//		board.setContent("���� �ۼ��ϴ� ����");
//		board.setWriter("newbie");
//
//		service.register(board);
//
//		log.info("������ �Խù��� ��ȣ: " + board.getBno());
	}

//	@Test
	public void testGetList() {
//		service.getList().forEach(board -> log.info(board));
		//service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}

//	@Test
	public void testGet() {
//		log.info(service.get(1L));
	}

//	@Test
	public void testDelete() {
		// �Խù� ��ȣ�� ���� ���θ� Ȯ���ϰ� �׽�Ʈ�� ��
//		log.info("REMOVE RESULT: " + service.remove(2L));
	}

	@Test
	public void testUpdate() {
//		BoardVO board = service.get(1L);
//		if (board == null) {
//			return;
//		}

//		board.setTitle("���� �����մϴ�.");
//		log.info("MODIFY RESULT: " + service.modify(board));
	}
}