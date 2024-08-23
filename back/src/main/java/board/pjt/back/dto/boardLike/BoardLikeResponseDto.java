package board.pjt.back.dto.boardLike;

import java.time.LocalDateTime;

public class BoardLikeResponseDto {
    Integer article_like_id;
    BoardLikeBoardInfo board;
    String created_by;
    LocalDateTime created_at;

    public BoardLikeResponseDto() {
    }

    public BoardLikeResponseDto(Integer article_like_id, BoardLikeBoardInfo board, String created_by, LocalDateTime created_at) {
        this.article_like_id = article_like_id;
        this.created_by = created_by;
        this.created_at = created_at;
        this.board = board;
    }

    public BoardLikeBoardInfo getBoard() {
        return board;
    }

    public void setBoard(BoardLikeBoardInfo board) {
        this.board = board;
    }

    public Integer getArticle_like_id() {
        return article_like_id;
    }

    public void setArticle_like_id(Integer article_like_id) {
        this.article_like_id = article_like_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }


}


