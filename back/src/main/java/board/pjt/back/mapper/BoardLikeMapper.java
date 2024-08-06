package board.pjt.back.mapper;

import board.pjt.back.domain.ArticleLikeDto;
import board.pjt.back.domain.boardLike.BoardLikeListRequestDto;
import board.pjt.back.domain.boardLike.BoardLikeResponseDto;
import board.pjt.back.domain.boardLike.BoardToggleLikeRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardLikeMapper {
    List<BoardLikeResponseDto> findByBoardLikeId(BoardLikeListRequestDto requestDto);


    List<BoardLikeResponseDto> selectAll();

    ArticleLikeDto select(int article_id);


    int delete(BoardToggleLikeRequestDto requestDto);

    int insert(BoardToggleLikeRequestDto requestDto);

}
