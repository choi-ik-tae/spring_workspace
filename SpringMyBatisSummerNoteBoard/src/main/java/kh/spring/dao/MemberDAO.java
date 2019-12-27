package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate jdbc;
	
	// 회원가입
	public int signup(MemberDTO dto) {
		return jdbc.insert("Members.signup",dto);
	}
	// 로그인
	public MemberDTO login(MemberDTO dto) {
		Map<String,String> param = new HashMap<>();
		param.put("id",dto.getId());
		param.put("pw",dto.getPw());
		
		return jdbc.selectOne("Members.login",param);
	}
	// 마이페이지
	public MemberDTO mypage(String id) {
		return jdbc.selectOne("Members.mypage",id);
	}
	// 회원목록
	public List<MemberDTO> memberlist() {
		return jdbc.selectList("Members.memberlist");
	}
	// 회원탈퇴
	public int memberout(String id) {
		return jdbc.delete("Members.memberout",id);
	}
	// 정보수정
	public int modify(MemberDTO dto) {
		return jdbc.update("Members.modify", dto);
	}
}
