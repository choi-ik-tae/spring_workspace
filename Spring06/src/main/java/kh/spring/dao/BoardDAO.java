package kh.spring.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardFileDTO;

@Repository
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbc;
	
	// 게시글 등록
	public int boardInsert(BoardDTO dto) throws Exception {
		String sql = "insert into board values(board_seq.nextval,?,?,?,0,sysdate)";
		
		return jdbc.update(sql, dto.getTitle(),dto.getId(),dto.getContents());
	}
	// 게시글 목록
	public List<BoardDTO> boardSelect() throws Exception {
		String sql = "select * from board";
		return jdbc.query(sql, new RowMapper<BoardDTO>() {
			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setContents(rs.getString("contents"));
				dto.setHit(rs.getInt("hit"));
				dto.setWrite_date(rs.getString("write_date"));
			
				return dto;
			}
		});
	}
	// 게시글 디테일 뷰
	public BoardDTO boardSelectBySeq(int seq) throws Exception {
		String sql = "select * from board where seq = ?";
		
		return jdbc.queryForObject(sql, new Object[] {seq}, new RowMapper<BoardDTO>() {
			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setContents(rs.getString("contents"));
				dto.setWrite_date(rs.getString("write_date"));
				dto.setHit(rs.getInt("hit"));
				
				return dto;
			}
		});
	}
	// 게시물 시퀀스 추출
	public List<Integer> boardSelectSeq(String id) throws Exception {
		String sql = "select seq from board where id = ? order by seq desc";
		
		return jdbc.query(sql, new Object[] {id} ,new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
		});
	}
	
	// 게시글 삭제
	public int boardDeleteById(String id,int seq) throws Exception {
		String sql = "delete from board where seq = ? and id = ?";
		return jdbc.update(sql, new Object[] {seq,id});
	}
	// 게시글 수정
	public int boardModify(String title, String contents, int seq, String id) throws Exception {
		String sql = "update board set title=?,contents=? where seq = ? and id = ?";
		return jdbc.update(sql, new Object[] {title,contents,seq,id});
	}
	
	// 조회수 증가
	public int hitCount(int seq) throws Exception {
		String sql = "update board set hit = hit + 1 where seq = ?";
		return jdbc.update(sql, new Object[] {seq});
	}
	
}
