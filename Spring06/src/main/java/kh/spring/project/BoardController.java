package kh.spring.project;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardFileDTO;
import kh.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private HttpSession session = null;
	
	@RequestMapping("/board.bo")
	public ModelAndView board() {		
		ModelAndView mav = new ModelAndView();
		try {
			List<BoardDTO> list = boardService.boardList();
			mav.addObject("list", list);
			mav.setViewName("board/board");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping("/boardWrite.bo")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	@RequestMapping("/boardWriteProc.bo")
	public ModelAndView boardWriteProc(BoardDTO dto,BoardFileDTO fdto) {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("loginInfo");
		String path = session.getServletContext().getRealPath("files");
				
		dto.setSeq(0);
		dto.setTitle(dto.getTitle());
		dto.setId(id);
		dto.setContents(dto.getContents());
		dto.setWrite_date(null);
		
		try {
			boardService.boardWrite(dto,fdto,path,id);
			mav.setViewName("redirect:board.bo");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
		}
		return mav;
	}
	
	@RequestMapping("/boardDetail.bo")
	public ModelAndView boardList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();		
		int seq = Integer.parseInt(req.getParameter("seq"));
		String id = (String)session.getAttribute("loginInfo");
		
		try {
			BoardDTO dto = boardService.boardDetailView(seq);
			List<BoardFileDTO> flist = boardService.boardFileList(seq);
			mav.addObject("dto", dto);
			mav.addObject("flist", flist);
			mav.addObject("id", id);
			mav.setViewName("board/boardDetailView");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
		}
		return mav;
	}
	
	@RequestMapping("/boardFileDownload.bo")
	public void boardFileDownload(String target,HttpServletRequest req,HttpServletResponse res) {
        String fileName = target;
        String path = session.getServletContext().getRealPath("files");
        String fullPath = path + "/" + fileName;
        
        File f = new File(fullPath);
        try(FileInputStream fis = new FileInputStream(f);
           DataInputStream fileDis = new DataInputStream(fis);
           ServletOutputStream sos = res.getOutputStream();){
        	
           byte[] fileContents = new byte[(int)f.length()];
           fileDis.readFully(fileContents);
           //--------------------------------------------------------
           res.reset(); // 기본값으로 가지고 있던 값을 초기화.
           res.setContentType("application/octet-stream"); // 어떤 종류의 데이터를 보낼것인지
           String encFileName = new String(fileName.getBytes("utf8"),"iso-8859-1"); // 인코딩 타입 변경.
           
           res.setHeader("Content-Disposition", "attachement; filename=\""+encFileName+"\""); // 파일 보낼때 쓰는 문법.
           res.setHeader("Content-Length", String.valueOf(f.length()));
           
           sos.write(fileContents);
           sos.flush();
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	@RequestMapping("/boardModify.bo")
	public ModelAndView boardModify(int seq) {
		ModelAndView mav = new ModelAndView();
		
		try {
			BoardDTO dto = boardService.boardSelectBySeq(seq);
			mav.addObject("dto", dto);
			mav.setViewName("board/boardModify");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
		}
		return mav;
	}
	
	@RequestMapping("/boardModifyProc.bo")
	public ModelAndView boardModifyProc(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		String id = (String)session.getAttribute("loginInfo");
		int seq = Integer.parseInt(req.getParameter("seq"));
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		try {
			int reulst = boardService.boardModify(title, contents, seq, id);
			mav.setViewName("redirect:board.bo");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
		}
		return mav;
	}
	
	@RequestMapping("/boardDelete.bo")
	public ModelAndView boardDelete(int seq) {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("loginInfo");
		String path = session.getServletContext().getRealPath("files");
		
		try {
			boardService.boardDelete(seq, id, path);
			mav.setViewName("redirect:board.bo");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
		}
		return mav;
	}
}
