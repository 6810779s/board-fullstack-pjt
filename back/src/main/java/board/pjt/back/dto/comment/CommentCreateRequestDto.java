package board.pjt.back.dto.comment;

import java.util.Objects;

public class CommentCreateRequestDto {
    private long comment_id;
    private long board_id;
    private Long parent_comment_id;
    private String content;
    private String created_by;

    public CommentCreateRequestDto() {
    }

    public CommentCreateRequestDto(long comment_id, long board_id, Long parent_comment_id, String content, String created_by) {
        this.comment_id = comment_id;
        this.board_id = board_id;
        this.parent_comment_id = parent_comment_id;
        this.content = content;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentCreateRequestDto that = (CommentCreateRequestDto) o;
        return Objects.equals(comment_id, that.comment_id) && Objects.equals(board_id, that.board_id) && Objects.equals(parent_comment_id, that.parent_comment_id) && Objects.equals(content, that.content) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_id, board_id, parent_comment_id, content, created_by);
    }

    @Override
    public String toString() {
        return "CommentCreateRequestDto{" +
                "comment_id=" + comment_id +
                ", board_id=" + board_id +
                ", parent_comment_id=" + parent_comment_id +
                ", content='" + content + '\'' +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public Long getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Long parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
