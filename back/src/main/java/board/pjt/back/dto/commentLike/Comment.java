package board.pjt.back.dto.commentLike;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comment {
    private int comment_id;
    private Integer parent_comment_id;
    private LocalDateTime created_at;
    private String created_by;

    public Comment() {
    }

    public Comment(int comment_id, Integer parent_comment_id, LocalDateTime created_at, String created_by) {
        this.comment_id = comment_id;
        this.parent_comment_id = parent_comment_id;
        this.created_at = created_at;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return comment_id == comment.comment_id && Objects.equals(parent_comment_id, comment.parent_comment_id) && Objects.equals(created_at, comment.created_at) && Objects.equals(created_by, comment.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_id, parent_comment_id, created_at, created_by);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", parent_comment_id=" + parent_comment_id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Integer parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
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
}
