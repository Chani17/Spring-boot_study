// BoardService interface에는 비즈니스 로직을 수행하기 위한 메서드를 정의한다.
package board.board.service;

import java.util.List;
import board.board.dto.BoardDto;

public interface BoardService {

	List<BoardDto> selectBoardList() throws Exception;
	
	void insertBoard(BoardDto board) throws Exception;
	
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	void updateBoard(BoardDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
}

