package board.pjt.back.dto.comment;

import java.util.Objects;

public class CommentDetailRequestDto {
    private long comment_id;

    public CommentDetailRequestDto() {
    }

    public CommentDetailRequestDto(long comment_id) {
        this.comment_id = comment_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDetailRequestDto that = (CommentDetailRequestDto) o;
        return comment_id == that.comment_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_id);
    }

    @Override
    public String toString() {
        return "CommentDetailRequestDto{" +
                "comment_id=" + comment_id +
                '}';
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }
}
