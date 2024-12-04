package board.pjt.back.dto.board;

import board.pjt.back.entity.BoardEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class BoardResponseDto {
    private String project_name;
    private long board_id;
    private String title;
    private String content;
    private long category_id;
    private LocalDateTime created_at;
    private String created_by;
    private LocalDateTime updated_at;
    private String updated_by;
    private int rating;
    private String main_image_path;

    public BoardResponseDto() {
    }

    public BoardResponseDto(String project_name, long board_id, String title, String content, long category_id, LocalDateTime created_at, String created_by, LocalDateTime updated_at, String updated_by, int rating, String main_image_path) {
        this.project_name = project_name;
        this.board_id = board_id;
        this.title = title;
        this.content = content;
        this.category_id = category_id;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.rating = rating;
        this.main_image_path = main_image_path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardResponseDto that = (BoardResponseDto) o;
        return board_id == that.board_id && category_id == that.category_id && rating == that.rating && Objects.equals(project_name, that.project_name) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(created_at, that.created_at) && Objects.equals(created_by, that.created_by) && Objects.equals(updated_at, that.updated_at) && Objects.equals(updated_by, that.updated_by) && Objects.equals(main_image_path, that.main_image_path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_name, board_id, title, content, category_id, created_at, created_by, updated_at, updated_by, rating, main_image_path);
    }

    @Override
    public String toString() {
        return "BoardResponseDto{" +
                "project_name='" + project_name + '\'' +
                ", board_id=" + board_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                ", rating=" + rating +
                ", main_image_path='" + main_image_path + '\'' +
                '}';
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMain_image_path() {
        return main_image_path;
    }

    public void setMain_image_path(String main_image_path) {
        this.main_image_path = main_image_path;
    }
}
