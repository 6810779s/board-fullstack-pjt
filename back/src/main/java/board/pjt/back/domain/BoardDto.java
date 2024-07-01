package board.pjt.back.domain;

import java.util.Date;
import java.util.Objects;

public class BoardDto {
    private Integer article_id;
    private String title;
    private String content;
    private Integer category_id;
    private Date created_at;
    private String created_by;
    private Date updated_at;
    private String updated_by;

    public BoardDto() {
    }

    public BoardDto(String title, String content, Integer category_id, String created_by) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return Objects.equals(article_id, boardDto.article_id) && Objects.equals(title, boardDto.title) && Objects.equals(content, boardDto.content) && Objects.equals(category_id, boardDto.category_id) && Objects.equals(created_at, boardDto.created_at) && Objects.equals(created_by, boardDto.created_by) && Objects.equals(updated_at, boardDto.updated_at) && Objects.equals(updated_by, boardDto.updated_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_id, title, content, category_id, created_at, created_by, updated_at, updated_by);
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
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


    @Override
    public String toString() {
        return "BoardDto{" +
                "article_id=" + article_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                '}';
    }
}
