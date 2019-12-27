package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	//게시물 출력
	public List<BoardDTO> selectAll() {
		return dao.selectAll();
	}
	// 게시물 시퀀스 번호 출력
	public int selectSeq() {
		return dao.selectSeq();
	}
	
}
