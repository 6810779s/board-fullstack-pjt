package board.pjt.back.mapper;

import board.pjt.back.dto.board.*;
import board.pjt.back.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    BoardDetailResponseDto select(@Param("article_id") Integer article_id);

    BoardDetailResponseDto getPrevArticle(Integer article);

    BoardDetailResponseDto getNextArticle(Integer article);

    List<BoardResponseDto> selectAll();

    List<BoardResponseDto> selectMyBoardList(UserEntity requestDto);

    void insert(BoardCreateRequestDto requestDto);

    void delete(BoardDeleteRequestDto requestDto);

    void update(BoardUpdateRequestDto requestDto);
}
