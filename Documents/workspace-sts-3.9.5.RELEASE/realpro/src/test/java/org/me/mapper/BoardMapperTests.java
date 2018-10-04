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
	
		board.setTitle("인성이는 배가 고픕니다.");
		board.setContent("뭘 먹으면 좋을까요?");
		board.setWriter("인성nyang");
		mapper.insert(board);
		log.info("결과 : "+board);
		}
	}
	
	@Test
	public void testRead() {

		BoardVO board = mapper.read(10L);
		
		log.info(board);
	}
	@Test
	public void testDelete() {
		
		log.info("삭제 결과"+mapper.delete(0L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		
		board.setBno(1L);
		board.setTitle("수정된 것");
		board.setContent("수정돼버린 내용");
		board.setWriter("갸아아아아악");
		int update = mapper.update(board);
		
		log.info("수정된 내용 : "+update);
	
	}
	
	}


