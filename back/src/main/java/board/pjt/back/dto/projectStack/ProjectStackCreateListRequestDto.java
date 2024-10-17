package board.pjt.back.dto.projectStack;

import java.util.List;
import java.util.Objects;

public class ProjectStackCreateListRequestDto {
    private int board_id;
    private List<ProjectStackInfo> project_stack;

    public ProjectStackCreateListRequestDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectStackCreateListRequestDto that = (ProjectStackCreateListRequestDto) o;
        return board_id == that.board_id && Objects.equals(project_stack, that.project_stack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, project_stack);
    }

    @Override
    public String toString() {
        return "ProjectStackCreateListRequestDto{" +
                "board_id=" + board_id +
                ", project_stack=" + project_stack +
                '}';
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public List<ProjectStackInfo> getProject_stack() {
        return project_stack;
    }

    public void setProject_stack(List<ProjectStackInfo> project_stack) {
        this.project_stack = project_stack;
    }
}
