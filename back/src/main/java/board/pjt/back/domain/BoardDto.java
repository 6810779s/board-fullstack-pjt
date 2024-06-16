package board.pjt.back.domain;

import java.util.Date;
import java.util.Objects;

public class BoardDto {
    private Integer article_id;
    private String user_email;
    private String title;
    private String content;
    private Integer category_id;
    private Date created_at;
    private String created_by;
    private Date modified_at;
    private String modified_by;

    public BoardDto() {
    }

    public BoardDto(String title, String content, Integer category_id) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return Objects.equals(article_id, boardDto.article_id) && Objects.equals(user_email, boardDto.user_email) && Objects.equals(title, boardDto.title) && Objects.equals(content, boardDto.content) && Objects.equals(created_by, boardDto.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_id, user_email, title, content, category_id);
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

    public Date getcreated_at() {
        return created_at;
    }

    public void setcreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getcreated_by() {
        return created_by;
    }

    public void setcreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getmodified_at() {
        return modified_at;
    }

    public void setmodified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public String getmodified_by() {
        return modified_by;
    }

    public void setmodified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "article_id=" + article_id +
                ", user_email='" + user_email + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", modified_at=" + modified_at +
                ", modified_by=" + modified_by +
                '}';
    }
}
