package board.pjt.back.dto;

import java.util.Date;
import java.util.Objects;

public class ArticleCommentsLikeDto {
    private int article_comments_like_id;
    private int comment_id;
    private Date created_at;
    private String created_by;

    public ArticleCommentsLikeDto() {
    }

    public ArticleCommentsLikeDto(int comment_id, String created_by) {
        this.comment_id = comment_id;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleCommentsLikeDto that = (ArticleCommentsLikeDto) o;
        return article_comments_like_id == that.article_comments_like_id && comment_id == that.comment_id && Objects.equals(created_at, that.created_at) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_comments_like_id, comment_id, created_at, created_by);
    }

    public int getArticle_comments_like_id() {
        return article_comments_like_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    @Override
    public String toString() {
        return "ArticleCommentsLikeDto{" +
                "article_comments_like_id=" + article_comments_like_id +
                ", comment_id=" + comment_id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                '}';
    }
}
