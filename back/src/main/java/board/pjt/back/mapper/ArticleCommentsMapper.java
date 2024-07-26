package board.pjt.back.mapper;

import board.pjt.back.domain.comment.CommentCreateRequestDto;
import board.pjt.back.domain.comment.CommentDeleteRequestDto;
import board.pjt.back.domain.comment.CommentResponseDto;
import board.pjt.back.domain.comment.CommentUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleCommentsMapper {
    CommentResponseDto select(@Param("article_comments_id") Integer article_comments_id);

    List<CommentResponseDto> selectAll();

    List<CommentResponseDto> selectAllReplyList(Integer parent_comment_id);


    void insert(CommentCreateRequestDto dto);

    void update(CommentUpdateRequestDto dto);

    void delete(CommentDeleteRequestDto dto);

}
