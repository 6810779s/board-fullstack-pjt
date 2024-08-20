package board.pjt.back.mapper;

import board.pjt.back.dto.commentLike.CommentLikeListRequestDto;
import board.pjt.back.dto.commentLike.CommentLikeResponseDto;
import board.pjt.back.dto.commentLike.CommentLikeToggleRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentLikeMapper {
    List<CommentLikeResponseDto> findByCommentId(CommentLikeListRequestDto commentLikeListRequestDto);

    int delete(CommentLikeToggleRequestDto requestDto);

    int insert(CommentLikeToggleRequestDto requestDto);
}
