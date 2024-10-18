package board.pjt.back.dto.comment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class CommentResponseDto {
    private Integer parent_comment_id;
    private int comment_id;
    private int board_id;
    private String content;
    private LocalDateTime created_at;
    private String created_by;
    private LocalDateTime updated_at;
    private String updated_by;

    public CommentResponseDto() {
    }

    public CommentResponseDto(Integer parent_comment_id, int comment_id, int board_id, String content, LocalDateTime created_at, String created_by, LocalDateTime updated_at, String updated_by) {
        this.parent_comment_id = parent_comment_id;
        this.comment_id = comment_id;
        this.board_id = board_id;
        this.content = content;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentResponseDto that = (CommentResponseDto) o;
        return comment_id == that.comment_id && board_id == that.board_id && Objects.equals(parent_comment_id, that.parent_comment_id) && Objects.equals(content, that.content) && Objects.equals(created_at, that.created_at) && Objects.equals(created_by, that.created_by) && Objects.equals(updated_at, that.updated_at) && Objects.equals(updated_by, that.updated_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent_comment_id, comment_id, board_id, content, created_at, created_by, updated_at, updated_by);
    }

    @Override
    public String toString() {
        return "CommentResponseDto{" +
                "parent_comment_id=" + parent_comment_id +
                ", comment_id=" + comment_id +
                ", board_id=" + board_id +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                '}';
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Integer parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}
