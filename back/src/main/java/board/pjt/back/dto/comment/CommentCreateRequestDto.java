package board.pjt.back.dto.comment;

import java.util.Objects;

public class CommentCreateRequestDto {
    private int comment_id;
    private int board_id;
    private Integer parent_comment_id;
    private String content;
    private String created_by;

    public CommentCreateRequestDto() {
    }

    public CommentCreateRequestDto(int comment_id, int board_id, Integer parent_comment_id, String content, String created_by) {
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

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Integer parent_comment_id) {
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
