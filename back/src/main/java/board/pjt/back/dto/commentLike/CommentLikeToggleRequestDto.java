package board.pjt.back.dto.commentLike;

import java.util.Objects;

public class CommentLikeToggleRequestDto {
    int comment_id;
    String created_by;

    public CommentLikeToggleRequestDto() {
    }

    public CommentLikeToggleRequestDto(int comment_id, String created_by) {
        this.comment_id = comment_id;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentLikeToggleRequestDto that = (CommentLikeToggleRequestDto) o;
        return comment_id == that.comment_id && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_id, created_by);
    }

    @Override
    public String toString() {
        return "CommentLikeToggleRequestDto{" +
                "comment_id=" + comment_id +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
