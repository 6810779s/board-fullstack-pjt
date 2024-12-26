package board.pjt.back.dto.board;

import java.util.Objects;

public class BoardCreateRequestDto {
    private long board_id;
    private String project_name;
    private int participant_limit;
    private String title;
    private String content;
    private int rating;
    private String main_image_path;
    private long category_id;
    private String created_by;

    public BoardCreateRequestDto() {
    }

    public BoardCreateRequestDto(long board_id, String project_name, int participant_limit, String title, String content, int rating, String main_image_path, long category_id, String created_by) {
        this.board_id = board_id;
        this.project_name = project_name;
        this.participant_limit = participant_limit;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.main_image_path = main_image_path;
        this.category_id = category_id;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCreateRequestDto that = (BoardCreateRequestDto) o;
        return board_id == that.board_id && participant_limit == that.participant_limit && rating == that.rating && category_id == that.category_id && created_by == that.created_by && Objects.equals(project_name, that.project_name) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(main_image_path, that.main_image_path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, project_name, participant_limit, title, content, rating, main_image_path, category_id, created_by);
    }

    @Override
    public String toString() {
        return "BoardCreateRequestDto{" +
                "board_id=" + board_id +
                ", project_name='" + project_name + '\'' +
                ", participant_limit=" + participant_limit +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", main_image_path='" + main_image_path + '\'' +
                ", category_id=" + category_id +
                ", created_by=" + created_by +
                '}';
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public long getBoard_id() {
        return board_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public int getParticipant_limit() {
        return participant_limit;
    }

    public void setParticipant_limit(int participant_limit) {
        this.participant_limit = participant_limit;
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

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
