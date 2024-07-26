package board.pjt.back.domain.comment;

import java.util.Objects;

public class CommentCreateRequestDto {
    private Integer article_comments_id;
    private Integer article_id;
    private Integer parent_comment_id;
    private String content;

    public CommentCreateRequestDto() {
    }

    public CommentCreateRequestDto(Integer article_comments_id, Integer article_id, Integer parent_comment_id, String content) {
        this.article_comments_id = article_comments_id;
        this.article_id = article_id;
        this.parent_comment_id = parent_comment_id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentCreateRequestDto{" +
                "article_comments_id=" + article_comments_id +
                ", article_id=" + article_id +
                ", parent_comment_id=" + parent_comment_id +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentCreateRequestDto that = (CommentCreateRequestDto) o;
        return Objects.equals(article_comments_id, that.article_comments_id) && Objects.equals(article_id, that.article_id) && Objects.equals(parent_comment_id, that.parent_comment_id) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_comments_id, article_id, parent_comment_id, content);
    }

    public Integer getArticle_comments_id() {
        return article_comments_id;
    }

    public void setArticle_comments_id(Integer article_comments_id) {
        this.article_comments_id = article_comments_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Integer parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
