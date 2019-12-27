package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardFileDTO;

@Repository
public class BoardFileDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	// 게시물 이름 DB 저장
	public int insertFile(int seq,BoardFileDTO dto) throws Exception {
		String sql = "insert into board_files values(board_file_seq.nextval,?,?,?)";
		return jdbc.update(sql, new Object[] {seq,dto.getOri_name(),dto.getSys_name()});
	}
	
	// 파일 목록 출력
	public List<BoardFileDTO> selectAllFiles(int target) throws Exception {
		String sql = "select * from board_files where board_seq = ?";
		return jdbc.query(sql, new Object[] {target}, new RowMapper<BoardFileDTO>() {
			@Override
			public BoardFileDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardFileDTO dto = new BoardFileDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setOri_name(rs.getString("ori_name"));
				dto.setSys_name(rs.getString("sys_name"));
				
				return dto;
			}
		});
	}
	
	// 파일 이름 추출
	public List<String> selectFileName(int target) throws Exception {
		String sql = "select sys_name from board_files where board_seq = ?";
		return jdbc.query(sql, new Object[] {target}, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("sys_name");
			}
		});
	}
	
	// 파일 삭제
	public int deleteFile(int seq) throws Exception {
		String sql = "delete from board_files where board_seq=?";
		return jdbc.update(sql, seq);
	}
}
