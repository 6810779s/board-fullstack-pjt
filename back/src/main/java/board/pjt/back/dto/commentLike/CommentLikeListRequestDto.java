package board.pjt.back.dto.commentLike;

public class CommentLikeListRequestDto {
    long comment_id;

    public CommentLikeListRequestDto() {
    }

    public CommentLikeListRequestDto(long comment_id) {
        this.comment_id = comment_id;
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }
}
