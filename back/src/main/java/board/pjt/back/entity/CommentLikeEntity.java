package board.pjt.back.entity;

import java.util.Date;
import java.util.Objects;

public class CommentLikeEntity {
    Integer article_comments_like_id;
    Integer comment_id;
    Date created_at;
    String created_by;

    public CommentLikeEntity() {
    }

    public CommentLikeEntity(Integer article_comments_like_id, Integer comment_id, Date created_at, String created_by) {
        this.article_comments_like_id = article_comments_like_id;
        this.comment_id = comment_id;
        this.created_at = created_at;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentLikeEntity that = (CommentLikeEntity) o;
        return Objects.equals(article_comments_like_id, that.article_comments_like_id) && Objects.equals(comment_id, that.comment_id) && Objects.equals(created_at, that.created_at) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_comments_like_id, comment_id, created_at, created_by);
    }

    public Integer getArticle_comments_like_id() {
        return article_comments_like_id;
    }

    public void setArticle_comments_like_id(Integer article_comments_like_id) {
        this.article_comments_like_id = article_comments_like_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
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
