package board.pjt.back.dto.commentLike;

import java.time.LocalDateTime;
import java.util.Objects;

public class Board {
    private int board_id;
    private String title;
    private LocalDateTime created_at;
    private String created_by;

    public Board() {
    }

    public Board(int board_id, String title, LocalDateTime created_at, String created_by) {
        this.board_id = board_id;
        this.title = title;
        this.created_at = created_at;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return board_id == board.board_id && Objects.equals(title, board.title) && Objects.equals(created_at, board.created_at) && Objects.equals(created_by, board.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, title, created_at, created_by);
    }

    @Override
    public String toString() {
        return "Board{" +
                "board_id=" + board_id +
                ", title='" + title + '\'' +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                '}';
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
