package board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.board.dto.BoardDto;

// 마이바티스의 매퍼 인터페이스임을 선언
@Mapper
public interface BoardMapper {
	// 인터페이스이기 때문에 메서드의 이름과 반환형식만 지정한다.
	// 여기서 지정한 메서드의 이름은 sql의 이름과 동일해야 한다.
	List<BoardDto> selectBoardList() throws Exception;
	
	void insertBoard(BoardDto board) throws Exception;
	
	void updateHitCount(int boardIdx) throws Exception;
	
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	void updateBoard(BoardDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
}
