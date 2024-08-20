package board.pjt.back.dto;

import java.util.Date;
import java.util.Objects;

public class ArticleCommentsDto {
    private int article_comments_id;
    private int article_id;
    private String content;
    private Date created_at;
    private String created_by;
    private Date updated_at;
    private String updated_by;

    public ArticleCommentsDto() {
    }

    public ArticleCommentsDto(int article_id, String content, String created_by, String updated_by) {
        this.article_id = article_id;
        this.content = content;
        this.created_by = created_by;
        this.updated_by = updated_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleCommentsDto that = (ArticleCommentsDto) o;
        return article_comments_id == that.article_comments_id && article_id == that.article_id && Objects.equals(content, that.content) && Objects.equals(created_at, that.created_at) && Objects.equals(created_by, that.created_by) && Objects.equals(updated_at, that.updated_at) && Objects.equals(updated_by, that.updated_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_comments_id, article_id, content, created_at, created_by, updated_at, updated_by);
    }

    @Override
    public String toString() {
        return "ArticleCommentsDto{" +
                "article_comments_id=" + article_comments_id +
                ", article_id=" + article_id +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                '}';
    }

    public int getComments_id() {
        return article_comments_id;
    }


    public int getArticle_id() {
        return article_id;
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


    public String getCreated_by() {
        return created_by;
    }


    public Date getUpdated_at() {
        return updated_at;
    }


    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}
