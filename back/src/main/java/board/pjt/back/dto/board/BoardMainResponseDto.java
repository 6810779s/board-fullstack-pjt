package board.pjt.back.dto.board;

import java.time.LocalDateTime;
import java.util.Objects;

public class BoardMainResponseDto {
    private long board_id;
    private String title;
    private String category_name;
    private String project_name;
    private String content;
    private int participant_cnt;
    private int participant_limit;
    private LocalDateTime created_at;
    private int like_cnt;
    private int comment_cnt;
    private String main_image_path;

    public BoardMainResponseDto() {
    }

    public BoardMainResponseDto(long board_id, String title, String category_name, String project_name, String content, int participant_cnt, int participant_limit, LocalDateTime created_at, int like_cnt, int comment_cnt, String main_image_path) {
        this.board_id = board_id;
        this.title = title;
        this.category_name = category_name;
        this.project_name = project_name;
        this.content = content;
        this.participant_cnt = participant_cnt;
        this.participant_limit = participant_limit;
        this.created_at = created_at;
        this.like_cnt = like_cnt;
        this.comment_cnt = comment_cnt;
        this.main_image_path = main_image_path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardMainResponseDto that = (BoardMainResponseDto) o;
        return board_id == that.board_id && participant_cnt == that.participant_cnt && participant_limit == that.participant_limit && like_cnt == that.like_cnt && comment_cnt == that.comment_cnt && Objects.equals(title, that.title) && Objects.equals(category_name, that.category_name) && Objects.equals(project_name, that.project_name) && Objects.equals(content, that.content) && Objects.equals(created_at, that.created_at) && Objects.equals(main_image_path, that.main_image_path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id,title, category_name, project_name, content, participant_cnt, participant_limit, created_at, like_cnt, comment_cnt, main_image_path);
    }

    @Override
    public String toString() {
        return "BoardMainResponseDto{" +
                "board_id='" + board_id + '\'' +
                ", title='" + title + '\'' +
                ", category_name='" + category_name + '\'' +
                ", project_name='" + project_name + '\'' +
                ", content='" + content + '\'' +
                ", participant_cnt=" + participant_cnt +
                ", participant_limit=" + participant_limit +
                ", created_at=" + created_at +
                ", like_cnt=" + like_cnt +
                ", comment_cnt=" + comment_cnt +
                ", main_image_path='" + main_image_path + '\'' +
                '}';
    }

    public long getBoard_id() {
        return board_id;
    }

    public int getParticipant_limit() {
        return participant_limit;
    }

    public void setParticipant_limit(int participant_limit) {
        this.participant_limit = participant_limit;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getMain_image_path() {
        return main_image_path;
    }

    public void setMain_image_path(String main_image_path) {
        this.main_image_path = main_image_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getParticipant_cnt() {
        return participant_cnt;
    }

    public void setParticipant_cnt(int participant_cnt) {
        this.participant_cnt = participant_cnt;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public int getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(int like_cnt) {
        this.like_cnt = like_cnt;
    }

    public int getComment_cnt() {
        return comment_cnt;
    }

    public void setComment_cnt(int comment_cnt) {
        this.comment_cnt = comment_cnt;
    }
}
