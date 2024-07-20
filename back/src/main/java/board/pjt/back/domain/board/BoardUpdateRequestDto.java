package board.pjt.back.domain.board;

import java.util.Objects;

public class BoardUpdateRequestDto {
    private Integer article_id;
    private String title;
    private String content;
    private Integer category_id;

    public BoardUpdateRequestDto() {
    }

    public BoardUpdateRequestDto(Integer article_id, String title, String content, Integer category_id) {
        this.article_id = article_id;
        this.title = title;
        this.content = content;
        this.category_id = category_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardUpdateRequestDto that = (BoardUpdateRequestDto) o;
        return Objects.equals(article_id, that.article_id) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(category_id, that.category_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_id, title, content, category_id);
    }

    @Override
    public String toString() {
        return "ArticleUpdateDto{" +
                "article_id=" + article_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                '}';
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

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
