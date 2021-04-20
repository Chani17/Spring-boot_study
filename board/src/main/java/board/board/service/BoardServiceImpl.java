package board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;

// 비즈니스 로직을 처리하는 서비스 클래스를 나타내는 어노테이션
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	// DB에 접근하는 DAO 빈을 선언
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		// 사용자의 요청을 처리하기 위한 비즈니스 로직을 구현
		return boardMapper.selectBoardList();
	}
	
	@Override
	public void insertBoard(BoardDto board) throws Exception {
		boardMapper.insertBoard(board);
	}
	
	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		
		// 선택된 게시글의 조회수 증가
		boardMapper.updateHitCount(boardIdx);
		
		// 선택된 게시글의 내용을 조회
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		
		return board;
	}
	
	@Override
	public void updateBoard(BoardDto board) throws Exception {
		boardMapper.updateBoard(board);
	}
	
	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}
}
