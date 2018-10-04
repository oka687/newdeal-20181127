package org.me.service;

import java.util.List;

import org.me.domain.BoardVO;
import org.me.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{

	
	@Setter(onMethod =@__({@Autowired}))
	private BoardMapper  mapper;

	@Override
	public void register(BoardVO board) {
		
		log.info("register......"+board);
		mapper.insert(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		
		log.info("getList.................."+bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify................"+board);
		
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("delete............."+bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
		
	}
	
	
	
	
}
