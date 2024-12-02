package board.pjt.back.dto.projectAttachment;

import java.util.Objects;

public class ProjectAttachmentDeleteRequestDto {
    private long board_id;

    public ProjectAttachmentDeleteRequestDto() {
    }

    public ProjectAttachmentDeleteRequestDto(long board_id) {
        this.board_id = board_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectAttachmentDeleteRequestDto that = (ProjectAttachmentDeleteRequestDto) o;
        return board_id == that.board_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id);
    }

    @Override
    public String toString() {
        return "ProjectAttachmentDeleteRequestDto{" +
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
