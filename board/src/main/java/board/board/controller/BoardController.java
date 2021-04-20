package board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import board.board.dto.BoardDto;
import board.board.service.BoardService;

// 스프링 MVC의 컨트롤러 의미
// 해당 클래스의 컨트롤러로 동작하게 한다.
@Controller
public class BoardController {

	@Autowired
	// 비즈니스 로직을 처리하는 서비스 빈을 연결
	private BoardService boardService;
	
	// 클라이언트에서 호출한 주소와 그것이 수행할 메서드를 연결
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {
		// 호출된 요청의 결과를 보여줄 뷰를 지정
		ModelAndView mv = new ModelAndView("board/boardList");
		
		// 게시글 목록 조회
		// "게시글 목록을 조회한다"는 비즈니스 로직을 수행하기 위해서 BoardService 클래스의
		// selectBoardList 메서드 호출한다. 게시글 목록을 저장하기 위해 List 인터페이스 사용
		List<BoardDto> list = boardService.selectBoardList();
		// 실행된 비즈니스 로직의 결과 값을 뷰에 list라는 이름으로 저장
		// 뷰에서 사용할 경우 list라는 이름으로 조회 결과를 사용할 수 있음
		mv.addObject("list", list);
		
		return mv;
	}
	
	// 게시글 작성화면을 호출하는 주소
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception {
		return  "/board/boardWrite";
	}
	
	// 작성된 게시글을 등록하는 주소
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception {
		// 사용자가 작성한 게시글을 저장하는 service영역의 메소드를 호출
		boardService.insertBoard(board);
		// 게시글이 등록된 후 게시글 목록화면으로 이동
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception {
		boardService.updateBoard(board);
		// 글이 수정되면 게시글 목록화면으로 이동
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
		// 글이 삭제되면 게시글 목록화면으로 이동
		return "redirect:/board/openBoardList.do";
	}
}
