package board.pjt.back.dto.boardLike;

import java.util.Objects;

public class BoardToggleLikeRequestDto {
    int board_id;
    String created_by;


    public BoardToggleLikeRequestDto() {
    }

    public BoardToggleLikeRequestDto(int board_id, String created_by) {
        this.board_id = board_id;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardToggleLikeRequestDto that = (BoardToggleLikeRequestDto) o;
        return board_id == that.board_id && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, created_by);
    }

    @Override
    public String toString() {
        return "BoardToggleLikeRequestDto{" +
                "board_id=" + board_id +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
