package board.pjt.back.dto.projectAttachment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ProjectAttachmentCreateListRequestDto {
    private int board_id;
    private List<ProjectAttachmentInfoDto> project_attachment;

    public ProjectAttachmentCreateListRequestDto() {
    }

    public ProjectAttachmentCreateListRequestDto(int board_id, List<ProjectAttachmentInfoDto> project_attachment) {
        this.board_id = board_id;
        this.project_attachment = project_attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectAttachmentCreateListRequestDto that = (ProjectAttachmentCreateListRequestDto) o;
        return board_id == that.board_id && Objects.equals(project_attachment, that.project_attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, project_attachment);
    }

    @Override
    public String toString() {
        return "ProjectAttachmentCreateListRequestDto{" +
                "board_id=" + board_id +
                ", project_attachment=" + project_attachment +
                '}';
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public List<ProjectAttachmentInfoDto> getProject_attachment() {
        return project_attachment;
    }

    public void setProject_attachment(List<ProjectAttachmentInfoDto> project_attachment) {
        this.project_attachment = project_attachment;
    }
}
