package board.pjt.back.dto.projectUrl;

import java.util.List;
import java.util.Objects;

public class ProjectUrlCreateRequestDto {
    private int board_id;

    private List<ProjectUrlInfo> project_url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectUrlCreateRequestDto that = (ProjectUrlCreateRequestDto) o;
        return board_id == that.board_id && Objects.equals(project_url, that.project_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, project_url);
    }

    @Override
    public String toString() {
        return "ProjectUrlCreateRequestDto{" +
                "board_id=" + board_id +
                ", project_url=" + project_url +
                '}';
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public List<ProjectUrlInfo> getProject_url() {
        return project_url;
    }

    public void setProject_url(List<ProjectUrlInfo> project_url) {
        this.project_url = project_url;
    }


}
