package board.pjt.back.dto.commentLike;

public class CommentLikeListRequestDto {
    int comment_id;

    public CommentLikeListRequestDto() {
    }

    public CommentLikeListRequestDto(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }
}
