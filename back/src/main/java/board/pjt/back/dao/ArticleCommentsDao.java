package board.pjt.back.dao;

import board.pjt.back.common.constants.ErrorMessages;
import board.pjt.back.domain.comment.*;
import board.pjt.back.mapper.ArticleCommentsMapper;
import board.pjt.back.mapper.BoardMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleCommentsDao implements ArticleCommentsMapper {
    private final ArticleCommentsMapper commentsMapper;
    private final BoardMapper boardMapper;


    public ArticleCommentsDao(ArticleCommentsMapper articleCommentsMapper, BoardMapper boardMapper) {
        this.commentsMapper = articleCommentsMapper;
        this.boardMapper = boardMapper;
    }


    @Override
    public CommentResponseDto select(CommentDetailRequestDto requestDto) {
        CommentResponseDto dto = commentsMapper.select(requestDto);
        if (dto == null) {
            throw new IllegalArgumentException(ErrorMessages.COMMENT_NOT_FOUND);
        }
        return dto;
    }

    @Override
    public List<CommentResponseDto> selectAll() {
        return commentsMapper.selectAll();
    }

    @Override
    public List<CommentResponseDto> selectAllReplyList(CommentReplyRequestDto requestDto) {
        return commentsMapper.selectAllReplyList(requestDto);
    }

    @Override
    public List<CommentResponseDto> selectAllCommentByArticleId(Integer article_id) {
        if (boardMapper.select(article_id) == null) {
            throw new IllegalArgumentException(ErrorMessages.ARTICLE_NOT_FOUND);
        }
        return commentsMapper.selectAllCommentByArticleId(article_id);
    }


    @Override
    public void insert(CommentCreateRequestDto requestDto) {
        if (boardMapper.select(requestDto.getArticle_id()) == null) {
            throw new IllegalArgumentException(ErrorMessages.ARTICLE_NOT_FOUND);
        }
        Integer parent_comment_id = requestDto.getParent_comment_id();
        if (parent_comment_id != null) {
            CommentDetailRequestDto commentRequestDto = new CommentDetailRequestDto();
            commentRequestDto.setArticle_comments_id(parent_comment_id);
            CommentResponseDto parentComment = commentsMapper.select(commentRequestDto);
            if (parentComment == null) {
                throw new IllegalArgumentException(ErrorMessages.COMMENT_NOT_FOUND);
            }
            if (!parentComment.getArticle_id().equals(requestDto.getArticle_id())) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_COMMENT);
            }
        }
        commentsMapper.insert(requestDto);
    }

    @Override
    public void update(CommentUpdateRequestDto requestDto) {
        CommentDetailRequestDto commentDetailRequestDto = setCommentDetailRequestDto(requestDto.getArticle_comments_id());
        CommentResponseDto comment = select(commentDetailRequestDto);
        if (comment == null) {
            throw new IllegalArgumentException(ErrorMessages.ARTICLE_NOT_FOUND);
        }
        commentsMapper.update(requestDto);
        CommentResponseDto updateComment = select(commentDetailRequestDto);
        if (updateComment == null || !updateComment.getContent().equals(requestDto.getContent())) {
            throw new RuntimeException("업데이트에 실패하였습니다.");
        }
    }

    @Override
    public void delete(CommentDeleteRequestDto requestDto) {
        CommentDetailRequestDto commentDetailRequestDto = setCommentDetailRequestDto(requestDto.getArticle_comments_id());
        CommentResponseDto comment = select(commentDetailRequestDto);
        if (comment == null) {
            throw new IllegalArgumentException(requestDto.getArticle_comments_id() + "번의 게시글이 존재하지 않습니다.");
        }
//        CommentResponseDto deletedComment = select(requestDto.getArticle_comments_id());
        commentsMapper.delete(requestDto);
//        if (deletedComment != null) {
//            throw new RuntimeException("게시물 삭제에 실패하였습니다.");
//        }
    }


    private CommentDetailRequestDto setCommentDetailRequestDto(Integer article_comments_id) {
        CommentDetailRequestDto requestDto = new CommentDetailRequestDto();
        requestDto.setArticle_comments_id(article_comments_id);
        return requestDto;
    }


}
