package board.pjt.back.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProjectUrlEntity {
    private int project_url_id;
    private int board_id;
    private String url;
    private LocalDateTime created_at;

    public ProjectUrlEntity(int project_url_id, int board_id, String url, LocalDateTime created_at) {
        this.project_url_id = project_url_id;
        this.board_id = board_id;
        this.url = url;
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectUrlEntity that = (ProjectUrlEntity) o;
        return project_url_id == that.project_url_id && board_id == that.board_id && Objects.equals(url, that.url) && Objects.equals(created_at, that.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_url_id, board_id, url, created_at);
    }

    @Override
    public String toString() {
        return "ProjectUrlEntity{" +
                "project_url_id=" + project_url_id +
                ", board_id=" + board_id +
                ", url='" + url + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    public int getProject_url_id() {
        return project_url_id;
    }

    public void setProject_url_id(int project_url_id) {
        this.project_url_id = project_url_id;
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
