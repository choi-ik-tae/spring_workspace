package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate jdbc;
	
	// 게시물 출력
	public List<BoardDTO> selectAll() {
		return jdbc.selectList("Board.selectAll");
	}
	// 게시물 작성
	public int boardwirte(BoardDTO dto) {
		return jdbc.insert("Board.boardWrite",dto);
	}
	// 게시물 시퀀스 추출
	public int selectSeq() {
		return jdbc.selectOne("Board.selectSeq");
	}
	
}
