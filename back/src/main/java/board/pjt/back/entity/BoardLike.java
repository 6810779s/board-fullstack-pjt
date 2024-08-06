package board.pjt.back.entity;

import java.util.Date;
import java.util.Objects;

public class BoardLike {
    Integer article_like_id;
    Integer article_id;
    Date created_at;
    String created_by;

    public BoardLike() {
    }

    public BoardLike(Integer article_like_id, Integer article_id, Date created_at, String created_by) {
        this.article_like_id = article_like_id;
        this.article_id = article_id;
        this.created_at = created_at;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardLike boardLike = (BoardLike) o;
        return Objects.equals(article_like_id, boardLike.article_like_id) && Objects.equals(article_id, boardLike.article_id) && Objects.equals(created_at, boardLike.created_at) && Objects.equals(created_by, boardLike.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_like_id, article_id, created_at, created_by);
    }

    @Override
    public String toString() {
        return "BoardLike{" +
                "article_like_id=" + article_like_id +
                ", article_id=" + article_id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                '}';
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
