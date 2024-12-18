package board.pjt.back.dto.board;

import java.util.Objects;

public class BoardSimpleInfo {
    private long board_id;
    private String title;

    public BoardSimpleInfo() {
    }

    public BoardSimpleInfo(long board_id, String title) {
        this.board_id = board_id;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardSimpleInfo that = (BoardSimpleInfo) o;
        return board_id == that.board_id && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, title);
    }

    @Override
    public String toString() {
        return "BoardSimpleInfo{" +
                "board_id=" + board_id +
                ", title='" + title + '\'' +
                '}';
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
