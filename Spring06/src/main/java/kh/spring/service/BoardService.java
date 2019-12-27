package kh.spring.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dao.BoardDAO;
import kh.spring.dao.BoardFileDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardFileDTO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;

	@Autowired
	private BoardFileDAO fdao;
	
	// 게시글 목록 출력
	public List<BoardDTO> boardList() throws Exception{
		return dao.boardSelect();
	}
	
	// 게시글 하나 추출
	public BoardDTO boardSelectBySeq(int seq) throws Exception {
		return dao.boardSelectBySeq(seq);
	}

	// 게시글 디테일 뷰 , 조회수 증가
	@Transactional("txManager")
	public BoardDTO boardDetailView(int seq) throws Exception{
		dao.hitCount(seq);
		return dao.boardSelectBySeq(seq);
	}
	
	// 게시글 파일 목록 출력
	public List<BoardFileDTO> boardFileList(int target) throws Exception {
		return fdao.selectAllFiles(target);
	}
	
	// 게시글 등록 및 파일 DB 등록 및 업로드
	@Transactional("txManager")
	public void boardWrite(BoardDTO dto,BoardFileDTO fdto,String path,String id) throws Exception{
		int result = dao.boardInsert(dto);
		if(result > 0) {
			// 시퀀스 추출
			List<Integer> seq = dao.boardSelectSeq(id);
			int target = seq.get(0);
			// 파일 dto에 board seq 값 설정
			fdto.setSeq(target);
			// 게시물 파일 업로드
			File filePath = new File(path);

			if (!filePath.exists()) {
				filePath.mkdir();
			}

			for (MultipartFile tmp : fdto.getFile()) {
				String oriName = tmp.getOriginalFilename();
				String sysName = System.currentTimeMillis() + "_" + oriName;
				fdto.setOri_name(oriName);
				fdto.setSys_name(sysName);
				try {
					tmp.transferTo(new File(path + "/" + sysName));
				} catch (Exception e) {
					e.printStackTrace();
				}
				fdao.insertFile(target, fdto);
			}
		}
	}
	
	// 게시글 수정
	public int boardModify(String title, String contents, int seq, String id) throws Exception{
		return dao.boardModify(title, contents, seq, id);
	}
	
	// 게시글 삭제
	public void boardDelete(int seq,String id,String path) throws Exception {
		dao.boardDeleteById(id, seq);
		List<String> fNames = fdao.selectFileName(seq);
	
		for(String tmp : fNames) {
			File file = new File(path+"/"+tmp);
			if (file.exists()) {
				if (file.delete()) {
					fdao.deleteFile(seq);
				} 
			} else {
				System.out.println("파일이 존재하지 않습니다.");
			}
		}
	}
}
