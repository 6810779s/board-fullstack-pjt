package board.pjt.back.dto.commentLike;

import java.util.Objects;

public class CommentLikeResponseDto {
    int comment_like_id;
    String created_by;
    Board board;
    Comment comment;


    public CommentLikeResponseDto() {
    }

    public CommentLikeResponseDto(int comment_like_id, String created_by, Board board, Comment comment) {
        this.comment_like_id = comment_like_id;
        this.created_by = created_by;
        this.board = board;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentLikeResponseDto that = (CommentLikeResponseDto) o;
        return comment_like_id == that.comment_like_id && Objects.equals(created_by, that.created_by) && Objects.equals(board, that.board) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_like_id, created_by, board, comment);
    }

    @Override
    public String toString() {
        return "CommentLikeResponseDto{" +
                "comment_like_id=" + comment_like_id +
                ", created_by='" + created_by + '\'' +
                ", board=" + board +
                ", comment=" + comment +
                '}';
    }

    public int getComment_like_id() {
        return comment_like_id;
    }

    public void setComment_like_id(int comment_like_id) {
        this.comment_like_id = comment_like_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
