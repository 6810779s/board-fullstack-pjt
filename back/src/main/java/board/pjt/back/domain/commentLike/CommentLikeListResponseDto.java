package board.pjt.back.domain.commentLike;

import java.util.List;

public class CommentLikeListResponseDto {
    List<CommentLikeResponseDto> commentLikeResponseDto;
    Integer commentLikeCnt;

    public CommentLikeListResponseDto() {
    }

    public CommentLikeListResponseDto(List<CommentLikeResponseDto> commentLikeResponseDto, Integer commentLikeCnt) {
        this.commentLikeResponseDto = commentLikeResponseDto;
        this.commentLikeCnt = commentLikeCnt;
    }

    public List<CommentLikeResponseDto> getCommentLikeResponseDto() {
        return commentLikeResponseDto;
    }

    public void setCommentLikeResponseDto(List<CommentLikeResponseDto> commentLikeResponseDto) {
        this.commentLikeResponseDto = commentLikeResponseDto;
        this.commentLikeCnt = commentLikeResponseDto.size();
    }

    public Integer getCommentLikeCnt() {
        return commentLikeCnt;
    }


}
