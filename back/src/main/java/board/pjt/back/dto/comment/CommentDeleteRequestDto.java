package board.pjt.back.dto.comment;

import java.util.Objects;

public class CommentDeleteRequestDto {
    private int comment_id;

    public CommentDeleteRequestDto() {
    }

    public CommentDeleteRequestDto(int comment_id) {
        this.comment_id = comment_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDeleteRequestDto that = (CommentDeleteRequestDto) o;
        return comment_id == that.comment_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_id);
    }

    @Override
    public String toString() {
        return "CommentDeleteRequestDto{" +
                "comment_id=" + comment_id +
                '}';
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }
}
