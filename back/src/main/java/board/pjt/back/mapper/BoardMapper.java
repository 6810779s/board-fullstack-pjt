package board.pjt.back.mapper;

import board.pjt.back.dto.board.BoardCreateRequestDto;
import board.pjt.back.dto.board.BoardDeleteRequestDto;
import board.pjt.back.dto.board.BoardResponseDto;
import board.pjt.back.dto.board.BoardUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    BoardResponseDto select(@Param("article_id") Integer article_id);

    List<BoardResponseDto> selectAll();

    void insert(BoardCreateRequestDto requestDto);

    void delete(BoardDeleteRequestDto requestDto);

    void update(BoardUpdateRequestDto requestDto);
}
