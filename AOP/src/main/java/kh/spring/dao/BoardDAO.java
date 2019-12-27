package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardFileDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate jdbc;
	
	// 게시물 출력
	public List<BoardDTO> selectAll() {
		return jdbc.selectList("Board.selectAll");
	}
	// 게시물 시퀀스 추출
	public List<BoardDTO> selectSeq() {
		return jdbc.selectList("Board.selectSeq");
	}
	// 게시물 작성
	public int boardWirte(BoardDTO dto) {
		return jdbc.insert("Board.boardWrite",dto);
	}
	public int boardFileWrite(BoardFileDTO fdto) {
		return jdbc.insert("Board.boardFileWrite", fdto);
	}
	// 게시물 디테일 뷰
	public BoardDTO selectPage(int seq) {
		return jdbc.selectOne("Board.selectPage",seq);
	}
	// 게시물 디테일 파일목록
	public List<BoardFileDTO> selectPageFileList(int seq) {
		return jdbc.selectList("Board.selectPageFileList",seq);
	}
	
}
