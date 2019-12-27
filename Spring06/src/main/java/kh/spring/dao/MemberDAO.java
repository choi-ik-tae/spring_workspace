package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbc;
	
	// 회원가입
	public int insert(MemberDTO dto) throws Exception {
		String sql = "insert into members values(?,?,?,?)";
		return jdbc.update(sql, dto.getId(),dto.getPw(),dto.getName(),dto.getPhone());
	}
	// 아이디 중복확인
	public int isExistId(String id) throws Exception {
		String sql = "select count(*) from members where id = ?";
		return jdbc.queryForObject(sql, Integer.class, id); // 뭐든 하나만 가져올때 사용
	}
	// 로그인
	public int login(String id,String pw)throws Exception {
		String sql = "select count(*) from members where id=? and pw=?";
		return jdbc.queryForObject(sql, Integer.class, id, pw);
	}
	// 회원목록
	public List<MemberDTO> getMemberList() throws Exception {
		String sql = "select * from members";
		// 추상클래스이거나 인터페이스인경우 인스턴스 생성 불가
		// 메서드의 내용을 구체화 가기전까지 인스턴스 생성 불가
		// 그래서 익명인스턴스 방식으로 생성
		// 자바스타일 콜백
		return jdbc.query(sql, new RowMapper<MemberDTO>() {
			// 반복문 알아서 돌림
			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException { 
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				
				return dto;
			}
		});
	}
	// 마이페이지
	public MemberDTO getMyInfo(String id) throws Exception {
		String sql = "select * from members where id = ?";
		
		return jdbc.queryForObject(sql, new Object[] {id}, new RowMapper<MemberDTO>() {
			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				
				return dto;
			}
		});
	}
	// 회원탈퇴
	public int deleteInfo(String id) throws Exception {
		String sql = "delete from members where id = ?";
		return jdbc.update(sql, id);
	}
	// 정보수정
	public int modifyInfo(MemberDTO dto) throws Exception {
		String sql = "update members set pw=?,name=?,phone=? where id=?";
		return jdbc.update(sql, dto.getPw(),dto.getName(),dto.getPhone(),dto.getId());
	}
	
	
}
