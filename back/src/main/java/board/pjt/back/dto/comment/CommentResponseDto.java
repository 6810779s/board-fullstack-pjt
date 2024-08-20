package board.pjt.back.dto.comment;

import java.util.Date;
import java.util.Objects;

public class CommentResponseDto {
    private Integer parent_comment_id;
    private Integer article_comments_id;
    private Integer article_id;
    private String content;
    private Date created_at;
    private String created_by;
    private Date updated_at;
    private String updated_by;

    public CommentResponseDto() {
    }

    public CommentResponseDto(Integer parent_comment_id, Integer article_comments_id, Integer article_id, String content, Date created_at, String created_by, Date updated_at, String updated_by) {
        this.parent_comment_id = parent_comment_id;
        this.article_comments_id = article_comments_id;
        this.article_id = article_id;
        this.content = content;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentResponseDto that = (CommentResponseDto) o;
        return Objects.equals(article_comments_id, that.article_comments_id) && Objects.equals(article_id, that.article_id) && Objects.equals(content, that.content) && Objects.equals(created_at, that.created_at) && Objects.equals(created_by, that.created_by) && Objects.equals(updated_at, that.updated_at) && Objects.equals(updated_by, that.updated_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_comments_id, article_id, content, created_at, created_by, updated_at, updated_by);
    }

    public Integer getArticle_comments_id() {
        return article_comments_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public String getContent() {
        return content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }
}
