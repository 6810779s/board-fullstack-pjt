package board.pjt.back.domain;

import java.util.Date;
import java.util.Objects;

public class BoardDto {
    private Integer article_id;
    private String user_email;
    private String title;
    private String content;
    private Integer category_id;
    private Date createdAt;
    private String createdBy;
    private Date modifiedAt;
    private String modifiedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return Objects.equals(article_id, boardDto.article_id) && Objects.equals(user_email, boardDto.user_email) && Objects.equals(title, boardDto.title) && Objects.equals(content, boardDto.content) && Objects.equals(createdBy, boardDto.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_id, user_email, title, content, category_id);
    }

    public BoardDto(){}
    public BoardDto( String title, String content, Integer category_id) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "article_id=" + article_id +
                ", user_email='" + user_email + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedAt=" + modifiedAt +
                ", modifiedBy=" + modifiedBy +
                '}';
    }
}
