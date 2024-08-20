package board.pjt.back.dto.commentLike;

public class CommentLikeListRequestDto {
    Integer comment_id;

    public CommentLikeListRequestDto() {
    }

    public CommentLikeListRequestDto(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }
}
