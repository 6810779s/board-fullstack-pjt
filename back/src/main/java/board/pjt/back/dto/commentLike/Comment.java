package board.pjt.back.dto.commentLike;

import java.time.LocalDateTime;

public class Comment {
    private Integer article_comments_id;
    private Integer parent_comment_id;
    private LocalDateTime created_at;
    private String created_by;

    public Comment() {
    }

    public Comment(Integer article_comments_id, Integer parent_comment_id, LocalDateTime created_at, String created_by) {
        this.article_comments_id = article_comments_id;
        this.parent_comment_id = parent_comment_id;
        this.created_at = created_at;
        this.created_by = created_by;
    }

    public Integer getArticle_comments_id() {
        return article_comments_id;
    }

    public void setArticle_comments_id(Integer article_comments_id) {
        this.article_comments_id = article_comments_id;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Integer parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
