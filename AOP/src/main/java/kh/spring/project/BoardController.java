package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardFileDTO;
import kh.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private HttpSession session = null;
	
	@Autowired
	private BoardService bService;
	
	@RequestMapping("/board.bo")
	public String board(Model m) {
		List<BoardDTO> list = bService.selectAll();
		m.addAttribute("list", list);
		
		return "board/board";
	}
	
	@RequestMapping("/boardWrite.bo")
	public String boardwrite() {
		return "board/boardWrite";
	}
	
	@RequestMapping("/boardWriteProc.bo")
	public String boardwriteProc(BoardDTO dto,BoardFileDTO fdto) {
		String id = (String)session.getAttribute("loginInfo");
		String path = session.getServletContext().getRealPath("files");
		
		dto.setId(id);
		bService.boardInsert(dto, fdto, path);
		
		return "redirect:board.bo";
	}
	
	@RequestMapping("/boardDetail.bo")
	public String boardDetail(int seq,Model m) {
		String id = (String)session.getAttribute("loginInfo");
		BoardDTO dto = bService.selectPage(seq);
		List<BoardFileDTO> flist = bService.selectPageFileList(seq);
		
		m.addAttribute("id", id);
		m.addAttribute("dto", dto);
		m.addAttribute("flist", flist);
		
		return "board/boardDetailView";
	}
	
}
