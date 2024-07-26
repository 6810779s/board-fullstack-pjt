package board.pjt.back.dao;

import board.pjt.back.domain.comment.CommentCreateRequestDto;
import board.pjt.back.domain.comment.CommentDeleteRequestDto;
import board.pjt.back.domain.comment.CommentResponseDto;
import board.pjt.back.domain.comment.CommentUpdateRequestDto;
import board.pjt.back.mapper.ArticleCommentsMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleCommentsDao implements ArticleCommentsMapper {
    private final ArticleCommentsMapper commentsMapper;

    public ArticleCommentsDao(ArticleCommentsMapper articleCommentsMapper) {
        this.commentsMapper = articleCommentsMapper;
    }


    @Override
    public CommentResponseDto select(Integer article_comments_id) {
        CommentResponseDto dto = commentsMapper.select(article_comments_id);
        if (dto == null) {
            throw new IllegalArgumentException("존재하지 않은 댓글입니다.");
        }
        return dto;
    }

    @Override
    public List<CommentResponseDto> selectAll() {
        return commentsMapper.selectAll();
    }

    @Override
    public List<CommentResponseDto> selectAllReplyList(Integer parent_comment_id) {
        return commentsMapper.selectAllReplyList(parent_comment_id);
    }


    @Override
    public void insert(CommentCreateRequestDto requestDto) {
        if (requestDto.getParent_comment_id() != null) {
            CommentResponseDto parentComment = commentsMapper.select(requestDto.getParent_comment_id());
            if (parentComment == null) {
                throw new IllegalArgumentException("존재하지 않는 댓글입니다.");
            }
            if (!parentComment.getArticle_id().equals(requestDto.getArticle_id())) {
                throw new IllegalArgumentException("잘못된 댓글 입니다. 상위 댓글과 게시글이 일치하지 않음.");
            }
        }
        commentsMapper.insert(requestDto);
    }

    @Override
    public void update(CommentUpdateRequestDto requestDto) {
        CommentResponseDto comment = select(requestDto.getArticle_comments_id());
        if (comment == null) {
            throw new IllegalArgumentException(requestDto.getArticle_comments_id() + "번의 게시글이 존재하지 않습니다.");
        }
        commentsMapper.update(requestDto);
        CommentResponseDto updateComment = select(requestDto.getArticle_comments_id());
        if (updateComment == null || !updateComment.getContent().equals(requestDto.getContent())) {
            throw new RuntimeException("업데이트에 실패하였습니다.");
        }
    }

    @Override
    public void delete(CommentDeleteRequestDto requestDto) {
        CommentResponseDto comment = select(requestDto.getArticle_comments_id());
        if (comment == null) {
            throw new IllegalArgumentException(requestDto.getArticle_comments_id() + "번의 게시글이 존재하지 않습니다.");
        }
        commentsMapper.delete(requestDto);
        CommentResponseDto deletedComment = select(requestDto.getArticle_comments_id());
        if (deletedComment != null) {
            throw new RuntimeException("게시물 삭제에 실패하였습니다.");
        }
    }


}
