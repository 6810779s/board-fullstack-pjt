package board.pjt.back.entity;

import java.util.Date;
import java.util.Objects;


public class Comment {
    private Integer article_comments_id;
    private String title;
    private Integer article_id;
    private String content;
    private Date created_at;
    private String created_by;
    private Date updated_at;
    private String updated_by;
    private Integer parent_comment_id;

    public Comment() {

    }

    public Comment(Integer article_comments_id, String title, Integer article_id, String content, Date created_at, String created_by, Date updated_at, String updated_by, Integer parent_comment_id) {
        this.article_comments_id = article_comments_id;
        this.title = title;
        this.article_id = article_id;
        this.content = content;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.parent_comment_id = parent_comment_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(article_comments_id, comment.article_comments_id) && Objects.equals(title, comment.title) && Objects.equals(article_id, comment.article_id) && Objects.equals(content, comment.content) && Objects.equals(created_at, comment.created_at) && Objects.equals(created_by, comment.created_by) && Objects.equals(updated_at, comment.updated_at) && Objects.equals(updated_by, comment.updated_by) && Objects.equals(parent_comment_id, comment.parent_comment_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_comments_id, title, article_id, content, created_at, created_by, updated_at, updated_by, parent_comment_id);
    }

    public Integer getArticle_comments_id() {
        return article_comments_id;
    }

    public void setArticle_comments_id(Integer article_comments_id) {
        this.article_comments_id = article_comments_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Integer parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }
}
