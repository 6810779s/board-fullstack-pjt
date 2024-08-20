package board.pjt.back.mapper;

import board.pjt.back.dto.comment.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleCommentsMapper {
    CommentResponseDto select(CommentDetailRequestDto requestDto);

    List<CommentResponseDto> selectAll();

    List<CommentResponseDto> selectAllReplyList(CommentReplyRequestDto requestDto);

    List<CommentResponseDto> selectAllCommentByArticleId(Integer article_id);

    void insert(CommentCreateRequestDto dto);

    void update(CommentUpdateRequestDto dto);

    void delete(CommentDeleteRequestDto dto);

}
