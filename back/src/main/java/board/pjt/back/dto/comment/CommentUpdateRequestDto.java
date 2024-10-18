package board.pjt.back.dto.comment;

public class CommentUpdateRequestDto {
    private int comment_id;
    private String content;

    private String updated_by;

    public CommentUpdateRequestDto() {
    }

    public CommentUpdateRequestDto(int comment_id, String content, String updated_by) {
        this.comment_id = comment_id;
        this.content = content;
        this.updated_by = updated_by;
    }

    public int getComment_id() {
        return comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}
