package board.pjt.back.dto.boardLike;

import java.time.LocalDateTime;
import java.util.Objects;

public class BoardLikeResponseDto {
    int board_like_id;
//    BoardLikeBoardInfo board;
    String created_by;
    LocalDateTime created_at;

    public BoardLikeResponseDto() {
    }

    public BoardLikeResponseDto(int board_like_id, String created_by, LocalDateTime created_at) {
        this.board_like_id = board_like_id;
        this.created_by = created_by;
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardLikeResponseDto that = (BoardLikeResponseDto) o;
        return board_like_id == that.board_like_id && Objects.equals(created_by, that.created_by) && Objects.equals(created_at, that.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_like_id, created_by, created_at);
    }

    @Override
    public String toString() {
        return "BoardLikeResponseDto{" +
                "board_like_id=" + board_like_id +
                ", created_by='" + created_by + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    public int getBoard_like_id() {
        return board_like_id;
    }

    public void setBoard_like_id(int board_like_id) {
        this.board_like_id = board_like_id;
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
}


