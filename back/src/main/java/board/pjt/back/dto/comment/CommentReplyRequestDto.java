package board.pjt.back.dto.comment;

public class CommentReplyRequestDto {
    private Long parent_comment_id;

    public CommentReplyRequestDto() {
    }

    public CommentReplyRequestDto(Long parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public long getParent_comment_id() {
        return parent_comment_id;
    }
}
