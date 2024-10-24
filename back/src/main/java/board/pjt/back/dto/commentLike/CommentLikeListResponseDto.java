package board.pjt.back.dto.commentLike;

import java.util.List;

public class CommentLikeListResponseDto {
    List<CommentLikeResponseDto> commentLikeResponseDto;
    int commentLikeCnt;

    public CommentLikeListResponseDto() {
    }

    public CommentLikeListResponseDto(List<CommentLikeResponseDto> commentLikeResponseDto, int commentLikeCnt) {
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

    public int getCommentLikeCnt() {
        return commentLikeCnt;
    }


}
