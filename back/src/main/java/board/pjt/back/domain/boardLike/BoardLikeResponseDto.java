package board.pjt.back.domain.boardLike;

import java.time.LocalDateTime;

public class BoardLikeResponseDto {
    Integer article_like_id;
    Integer article_id;
    String created_by;
    LocalDateTime created_at;

    public BoardLikeResponseDto() {
    }

    public BoardLikeResponseDto(Integer article_like_id, Integer article_id, String created_by, LocalDateTime created_at) {
        this.article_like_id = article_like_id;
        this.article_id = article_id;
        this.created_by = created_by;
        this.created_at = created_at;
    }

    public Integer getArticle_like_id() {
        return article_like_id;
    }

    public void setArticle_like_id(Integer article_like_id) {
        this.article_like_id = article_like_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
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
