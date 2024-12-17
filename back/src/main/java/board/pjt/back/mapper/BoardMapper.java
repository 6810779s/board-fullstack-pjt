package board.pjt.back.mapper;

import board.pjt.back.dto.board.*;
import board.pjt.back.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    List<BoardMainResponseDto> selectAll(Map param);
    BoardDetailResponseDto select(@Param("board_id") long board_id);

    List<BoardMainResponseDto> getBoardByCriteria(Map param);
    BoardDetailResponseDto getPrevBoard(long board_id);

    BoardDetailResponseDto getNextBoard(long board_id);


    List<BoardMainResponseDto> selectMyBoardList(UserEntity requestDto);

    void insert(BoardCreateRequestDto requestDto);

    void delete(BoardDeleteRequestDto requestDto);

    void update(BoardUpdateRequestDto requestDto);
}
