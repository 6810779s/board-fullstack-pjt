package board.pjt.back.domain;

import java.util.Date;
import java.util.Objects;

public class ArticleLikeDto {
    private int article_like_id;
    private int article_id;
    private Date created_at;
    private String created_by;

    public ArticleLikeDto() {
    }

    public ArticleLikeDto(int article_id, String created_by) {
        this.article_id = article_id;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleLikeDto that = (ArticleLikeDto) o;
        return article_like_id == that.article_like_id && article_id == that.article_id && Objects.equals(created_at, that.created_at) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_like_id, article_id, created_at, created_by);
    }

    public int getArticle_like_id() {
        return article_like_id;
    }


    public int getArticle_id() {
        return article_id;
    }


    public Date getCreated_at() {
        return created_at;
    }


    public String getCreated_by() {
        return created_by;
    }


    @Override
    public String toString() {
        return "ArticleLikeDto{" +
                "article_like_id=" + article_like_id +
                ", article_id=" + article_id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                '}';
    }
}
