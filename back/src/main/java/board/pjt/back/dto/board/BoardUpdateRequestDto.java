package board.pjt.back.dto.board;

import java.util.Objects;

public class BoardUpdateRequestDto {
    private int board_id;
    private String title;
    private String content;
    private int category_id;

    public BoardUpdateRequestDto() {
    }

    @Override
    public String toString() {
        return "BoardUpdateRequestDto{" +
                "board_id=" + board_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardUpdateRequestDto that = (BoardUpdateRequestDto) o;
        return board_id == that.board_id && category_id == that.category_id && Objects.equals(title, that.title) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, title, content, category_id);
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
