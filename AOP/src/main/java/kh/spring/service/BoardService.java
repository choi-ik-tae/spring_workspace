package kh.spring.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardFileDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	// 게시물 출력
	public List<BoardDTO> selectAll() {
		return dao.selectAll();
	}
	// 게시물 시퀀스 번호 출력
	public List<BoardDTO> selectSeq() {
		return dao.selectSeq();
	}
	// 게시물 작성
	@Transactional("txManager")
	public void boardInsert(BoardDTO dto,BoardFileDTO fdto,String path) {
		int result = dao.boardWirte(dto);
		
		if(result > 0) {
			int seq = selectSeq().get(0).getSeq();
			File filePath = new File(path);

			if (!filePath.exists()) {
				filePath.mkdir();
			}

			for (MultipartFile tmp : fdto.getFiles()) {
				String oriName = tmp.getOriginalFilename();
				String sysName = System.currentTimeMillis() + "_" + oriName;
				fdto.setOri_name(oriName);
				fdto.setSys_name(sysName);
				try {
					tmp.transferTo(new File(path + "/" + sysName));
				} catch (Exception e) {
					e.printStackTrace();
				}
				fdto.setBoard_seq(seq);
				dao.boardFileWrite(fdto);
			}
		}		
	}
	// 게시물 디테일
	public BoardDTO selectPage(int seq) {
		return dao.selectPage(seq);
	}
	public List<BoardFileDTO> selectPageFileList(int seq) {
		return dao.selectPageFileList(seq);
	}
}
