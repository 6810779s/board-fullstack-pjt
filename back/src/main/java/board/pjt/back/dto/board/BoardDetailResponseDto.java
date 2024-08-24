package board.pjt.back.dto.board;

import board.pjt.back.dto.category.CategorySelectResponseDto;

import java.time.LocalDateTime;

public class BoardDetailResponseDto {
    private Integer article_id;
    private String title;
    private String content;
    private CategorySelectResponseDto category;
    private BoardDetailResponseDto prevArticle;
    private BoardDetailResponseDto nextArticle;

    private String created_by;
    private LocalDateTime created_at;

    public BoardDetailResponseDto() {
    }

    public BoardDetailResponseDto(Integer article_id, String title, String content, CategorySelectResponseDto category, BoardDetailResponseDto prevArticle, BoardDetailResponseDto nextArticle, String created_by, LocalDateTime created_at) {
        this.article_id = article_id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.prevArticle = prevArticle;
        this.nextArticle = nextArticle;
        this.created_by = created_by;
        this.created_at = created_at;
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

    public CategorySelectResponseDto getCategory() {
        return category;
    }

    public void setCategory(CategorySelectResponseDto category) {
        this.category = category;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public BoardDetailResponseDto getPrevArticle() {
        return prevArticle;
    }

    public void setPrevArticle(BoardDetailResponseDto prevArticle) {
        this.prevArticle = prevArticle;
    }

    public BoardDetailResponseDto getNextArticle() {
        return nextArticle;
    }

    public void setNextArticle(BoardDetailResponseDto nextArticle) {
        this.nextArticle = nextArticle;
    }
}
