package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	// 회원가입
	public int signup(MemberDTO dto) {
		return dao.signup(dto);
	}
	// 로그인
	public MemberDTO login(MemberDTO dto) {
		return dao.login(dto);
	}
	// 마이페이지
	public MemberDTO mypage(String id) {
		return dao.mypage(id);
	}
	// 회원목록
	public List<MemberDTO> memberlist() {
		return dao.memberlist();
	}
	// 회원 탈퇴
	public int memberout(String id) {
		return dao.memberout(id);
	}
	// 정보 수정
	public int modfify(MemberDTO dto) {
		return dao.modify(dto);
	}
}
