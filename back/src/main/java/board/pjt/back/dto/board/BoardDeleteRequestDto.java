package board.pjt.back.dto.board;

import java.util.Objects;

public class BoardDeleteRequestDto {
    private Integer article_id;

    public BoardDeleteRequestDto() {

    }

    public BoardDeleteRequestDto(Integer article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "BoardDeleteRequestDto{" +
                "article_id=" + article_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDeleteRequestDto that = (BoardDeleteRequestDto) o;
        return Objects.equals(article_id, that.article_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_id);
    }

    public Integer getArticle_id() {
        return article_id;
    }
}
