package board.board.dto;
import lombok.Data;

// @Data : 모든 필드의 getter와 setter를 생성하고 toString, hashCode, equals 메서드도 생성.
// 하지만 setter의 경우 final이 선언되지 안은 필드에만 적용
@Data
public class BoardDto {
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private String createdDatetime;
	private String updaterId;
	private String updatedDatetime;
}
