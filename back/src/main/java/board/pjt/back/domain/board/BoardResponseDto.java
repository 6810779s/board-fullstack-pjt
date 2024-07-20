package board.pjt.back.domain.board;

import board.pjt.back.entity.Board;

import java.util.Date;
import java.util.Objects;

public class BoardResponseDto {
    private Integer article_id;
    private String title;
    private String content;
    private Integer category_id;
    private Date created_at;
    private String created_by;
    private Date updated_at;
    private String updated_by;

    public BoardResponseDto() {
    }

    public BoardResponseDto(Board board) {
        this.article_id = board.getArticle_id();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.category_id = board.getCategory_id();
        this.created_at = board.getCreated_at();
        this.created_by = board.getCreated_by();
        this.updated_at = board.getUpdated_at();
        this.updated_by = board.getUpdated_by();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardResponseDto that = (BoardResponseDto) o;
        return Objects.equals(article_id, that.article_id) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(category_id, that.category_id) && Objects.equals(created_at, that.created_at) && Objects.equals(created_by, that.created_by) && Objects.equals(updated_at, that.updated_at) && Objects.equals(updated_by, that.updated_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_id, title, content, category_id, created_at, created_by, updated_at, updated_by);
    }

    @Override
    public String toString() {
        return "BoardResponseDto{" +
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

    public Integer getArticle_id() {
        return article_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
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
}
