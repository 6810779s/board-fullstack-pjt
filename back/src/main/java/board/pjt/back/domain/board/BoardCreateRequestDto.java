package board.pjt.back.domain.board;

import java.util.Objects;

public class BoardCreateRequestDto {
    private String title;
    private String content;
    private Integer category_id;

    public BoardCreateRequestDto() {
    }

    public BoardCreateRequestDto(String title, String content, Integer category_id) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;

    }

    @Override
    public String toString() {
        return "BoardCreateRequestDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCreateRequestDto that = (BoardCreateRequestDto) o;
        return Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(category_id, that.category_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, category_id);
    }

}
