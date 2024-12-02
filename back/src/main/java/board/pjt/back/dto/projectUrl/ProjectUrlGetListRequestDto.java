package board.pjt.back.dto.projectUrl;

import java.util.Objects;

public class ProjectUrlGetListRequestDto {
    private long board_id;

    public ProjectUrlGetListRequestDto() {
    }

    public ProjectUrlGetListRequestDto(long board_id) {
        this.board_id = board_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectUrlGetListRequestDto that = (ProjectUrlGetListRequestDto) o;
        return board_id == that.board_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id);
    }

    @Override
    public String toString() {
        return "ProjectUrlGetListRequestDto{" +
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
