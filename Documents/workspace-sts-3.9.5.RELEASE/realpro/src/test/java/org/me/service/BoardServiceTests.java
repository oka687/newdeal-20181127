package org.me.service;

import java.util.List;

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
public class BoardServiceTests {

	@Setter(onMethod = @__({ @Autowired }))
	private BoardService service;
	
	
	@Test
	public void testRegister() {
		
		
		BoardVO board = new BoardVO();
		
		board.setTitle(102+"번 째 게시물");
		board.setContent(102+"번 째 내용");
		board.setWriter(102+"번 째 작성자");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : "+board.getBno());
	}
	
	@Test 
	public void testGet(){
		
		log.info(service.get(1L));
	}
	@Test
	public void testUpdate() {
	    BoardVO board = service.get(2L);

	    if (board == null) {
	      return;
	    }

	    board.setTitle("제목 수정합니다.");
	    log.info("MODIFY RESULT: " + service.modify(board));
	}
	@Test
	public void testDelete() {

		log.info(service.remove(1L));
	}
	@Test
	public void testGetList() {
		
		service.getList().forEach(board -> log.info(board));
	}

	
}
