package org.me.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.me.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod = @__({@Autowired}))
	private BoardMapper mapper;
	 
	@Test
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		for(int i =0; i<100; i++) {
		BoardVO board = new BoardVO();
	
		board.setTitle("�μ��̴� �谡 ���Ŵϴ�.");
		board.setContent("�� ������ �������?");
		board.setWriter("�μ�nyang");
		mapper.insert(board);
		log.info("��� : "+board);
		}
	}
	
	@Test
	public void testRead() {

		BoardVO board = mapper.read(10L);
		
		log.info(board);
	}
	@Test
	public void testDelete() {
		
		log.info("���� ���"+mapper.delete(0L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		
		board.setBno(1L);
		board.setTitle("������ ��");
		board.setContent("�����Ź��� ����");
		board.setWriter("���ƾƾƾƾ�");
		int update = mapper.update(board);
		
		log.info("������ ���� : "+update);
	
	}
	
	}


