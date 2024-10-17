package board.pjt.back.dto.projectAttachment;

import java.util.Objects;

public class ProjectAttachmentGetListRequestDto {
    private int board_id;

    public ProjectAttachmentGetListRequestDto() {
    }

    public ProjectAttachmentGetListRequestDto(int board_id) {
        this.board_id = board_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectAttachmentGetListRequestDto that = (ProjectAttachmentGetListRequestDto) o;
        return board_id == that.board_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id);
    }

    @Override
    public String toString() {
        return "ProjectAttachmentGetListRequestDto{" +
                "board_id=" + board_id +
                '}';
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }
}
