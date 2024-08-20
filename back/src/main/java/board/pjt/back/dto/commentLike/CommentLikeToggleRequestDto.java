package board.pjt.back.dto.commentLike;

public class CommentLikeToggleRequestDto {
    Integer comment_id;
    String created_by;

    public CommentLikeToggleRequestDto() {
    }

    public CommentLikeToggleRequestDto(Integer comment_id, String created_by) {
        this.comment_id = comment_id;
        this.created_by = created_by;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
