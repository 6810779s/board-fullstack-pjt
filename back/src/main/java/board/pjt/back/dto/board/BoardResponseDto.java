package board.pjt.back.dto.board;

import board.pjt.back.dto.category.CategorySelectResponseDto;
import board.pjt.back.entity.BoardEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class BoardResponseDto {
    private long board_id;
    private String project_name;
    private CategorySelectResponseDto category;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String main_image_path;
    private int board_like_cnt;
    private int participant_cnt;
    private int comment_cnt;



    public BoardResponseDto() {
    }

    public BoardResponseDto(long board_id, String project_name, CategorySelectResponseDto category, String title, String content, LocalDateTime created_at, LocalDateTime updated_at, String main_image_path, int board_like_cnt, int participant_cnt, int comment_cnt) {
        this.board_id = board_id;
        this.project_name = project_name;
        this.category = category;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.main_image_path = main_image_path;
        this.board_like_cnt = board_like_cnt;
        this.participant_cnt = participant_cnt;
        this.comment_cnt = comment_cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardResponseDto that = (BoardResponseDto) o;
        return board_id == that.board_id && board_like_cnt == that.board_like_cnt && participant_cnt == that.participant_cnt && comment_cnt == that.comment_cnt && Objects.equals(project_name, that.project_name) && Objects.equals(category, that.category) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(created_at, that.created_at) && Objects.equals(updated_at, that.updated_at) && Objects.equals(main_image_path, that.main_image_path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, project_name, category, title, content, created_at, updated_at, main_image_path, board_like_cnt, participant_cnt, comment_cnt);
    }

    @Override
    public String toString() {
        return "BoardResponseDto{" +
                "board_id=" + board_id +
                ", project_name='" + project_name + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", main_image_path='" + main_image_path + '\'' +
                ", board_like_cnt=" + board_like_cnt +
                ", participant_cnt=" + participant_cnt +
                ", comment_cnt=" + comment_cnt +
                '}';
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public CategorySelectResponseDto getCategory() {
        return category;
    }

    public void setCategory(CategorySelectResponseDto category) {
        this.category = category;
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getMain_image_path() {
        return main_image_path;
    }

    public void setMain_image_path(String main_image_path) {
        this.main_image_path = main_image_path;
    }

    public int getBoard_like_cnt() {
        return board_like_cnt;
    }

    public void setBoard_like_cnt(int board_like_cnt) {
        this.board_like_cnt = board_like_cnt;
    }

    public int getParticipant_cnt() {
        return participant_cnt;
    }

    public void setParticipant_cnt(int participant_cnt) {
        this.participant_cnt = participant_cnt;
    }

    public int getComment_cnt() {
        return comment_cnt;
    }

    public void setComment_cnt(int comment_cnt) {
        this.comment_cnt = comment_cnt;
    }


}
