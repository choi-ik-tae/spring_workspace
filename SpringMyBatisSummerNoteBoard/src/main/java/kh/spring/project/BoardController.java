package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.BoardDTO;
import kh.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private HttpSession session = null;
	
	@Autowired
	private BoardService bService;
	
	@RequestMapping("/board.bo")
	public ModelAndView board() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = bService.selectAll();
		
		mav.addObject("list", list);
		mav.setViewName("board/board");
		
		return mav;
	}
	
	@RequestMapping("/boardwrite.bo")
	public String boardwrite() {
		return "board/baordwrite";
	}
	
	@RequestMapping("/boardwriteProc.bo")
	public String boardwriteProc(BoardDTO dto) {
		
		int seq = bService.selectSeq();
		System.out.println();
		
		return "redirect:board.bo";
	}
	
}
