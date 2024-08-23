package board.pjt.back.mapper;

import board.pjt.back.dto.ArticleLikeDto;
import board.pjt.back.dto.boardLike.BoardLikeListRequestDto;
import board.pjt.back.dto.boardLike.BoardLikeResponseDto;
import board.pjt.back.dto.boardLike.BoardToggleLikeRequestDto;
import board.pjt.back.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardLikeMapper {
    List<BoardLikeResponseDto> findByBoardLikeId(BoardLikeListRequestDto requestDto);


    List<BoardLikeResponseDto> selectAll();

    List<BoardLikeResponseDto> selectMyBoardLikeList(UserEntity userEntity);

    ArticleLikeDto select(int article_id);


    int delete(BoardToggleLikeRequestDto requestDto);

    int insert(BoardToggleLikeRequestDto requestDto);

}
