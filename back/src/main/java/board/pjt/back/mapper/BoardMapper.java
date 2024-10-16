package board.pjt.back.mapper;

import board.pjt.back.dto.board.*;
import board.pjt.back.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardResponseDto> selectAll();
    BoardDetailResponseDto select(@Param("board_id") int board_id);

    BoardDetailResponseDto getPrevBoard(int board_id);

    BoardDetailResponseDto getNextBoard(int board_id);


    List<BoardResponseDto> selectMyBoardList(UserEntity requestDto);

    void insert(BoardCreateRequestDto requestDto);

    void delete(BoardDeleteRequestDto requestDto);

    void update(BoardUpdateRequestDto requestDto);
}
