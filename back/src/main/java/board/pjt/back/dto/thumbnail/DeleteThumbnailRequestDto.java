package board.pjt.back.dto.thumbnail;

import java.util.Objects;

public class DeleteThumbnailRequestDto {
    private long board_id;

    public DeleteThumbnailRequestDto() {
    }

    public DeleteThumbnailRequestDto(long board_id) {
        this.board_id = board_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteThumbnailRequestDto that = (DeleteThumbnailRequestDto) o;
        return board_id == that.board_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id);
    }

    @Override
    public String toString() {
        return "DeleteThumbnailRequestDto{" +
                "board_id=" + board_id +
                '}';
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }
}
