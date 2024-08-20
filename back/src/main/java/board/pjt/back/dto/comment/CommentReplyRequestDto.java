package board.pjt.back.dto.comment;

public class CommentReplyRequestDto {
    private Integer parent_comment_id;

    public CommentReplyRequestDto() {
    }

    public CommentReplyRequestDto(Integer parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }
}
