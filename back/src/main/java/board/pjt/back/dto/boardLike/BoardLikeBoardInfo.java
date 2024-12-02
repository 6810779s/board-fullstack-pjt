package board.pjt.back.dto.boardLike;

import java.util.Objects;

public class BoardLikeBoardInfo {
    long board_id;
    String title;

    public BoardLikeBoardInfo() {
    }

    public BoardLikeBoardInfo(long board_id, String title) {
        this.board_id = board_id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "BoardLikeBoardInfo{" +
                "board_id=" + board_id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardLikeBoardInfo that = (BoardLikeBoardInfo) o;
        return board_id == that.board_id && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, title);
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
