package board.pjt.back.dto.board;

import board.pjt.back.dto.category.CategorySelectResponseDto;

import java.time.LocalDateTime;
import java.util.Objects;

public class BoardDetailResponseDto {
    private String project_name;
    private String title;
    private String content;
    private CategorySelectResponseDto category;
    private int rating;
    private String main_image_path;
    private BoardSimpleInfo prevBoard;
    private BoardSimpleInfo nextBoard;
    private String created_by;
    private LocalDateTime created_at;
    private int participant_cnt;
    private int participant_limit;
    private int like_cnt;
    private int comment_cnt;

    public BoardDetailResponseDto() {
    }

    public BoardDetailResponseDto(String project_name, String title, String content, CategorySelectResponseDto category, int rating, String main_image_path, BoardSimpleInfo prevBoard, BoardSimpleInfo nextBoard, String created_by, LocalDateTime created_at, int participant_cnt, int participant_limit, int like_cnt, int comment_cnt) {
        this.project_name = project_name;
        this.title = title;
        this.content = content;
        this.category = category;
        this.rating = rating;
        this.main_image_path = main_image_path;
        this.prevBoard = prevBoard;
        this.nextBoard = nextBoard;
        this.created_by = created_by;
        this.created_at = created_at;
        this.participant_cnt = participant_cnt;
        this.participant_limit = participant_limit;
        this.like_cnt = like_cnt;
        this.comment_cnt = comment_cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDetailResponseDto that = (BoardDetailResponseDto) o;
        return rating == that.rating && participant_cnt == that.participant_cnt && participant_limit == that.participant_limit && like_cnt == that.like_cnt && comment_cnt == that.comment_cnt && Objects.equals(project_name, that.project_name) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(category, that.category) && Objects.equals(main_image_path, that.main_image_path) && Objects.equals(prevBoard, that.prevBoard) && Objects.equals(nextBoard, that.nextBoard) && Objects.equals(created_by, that.created_by) && Objects.equals(created_at, that.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_name, title, content, category, rating, main_image_path, prevBoard, nextBoard, created_by, created_at, participant_cnt, participant_limit, like_cnt, comment_cnt);
    }

    @Override
    public String toString() {
        return "BoardDetailResponseDto{" +
                "project_name='" + project_name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                ", main_image_path='" + main_image_path + '\'' +
                ", prevBoard=" + prevBoard +
                ", nextBoard=" + nextBoard +
                ", created_by='" + created_by + '\'' +
                ", created_at=" + created_at +
                ", participant_cnt=" + participant_cnt +
                ", participant_limit=" + participant_limit +
                ", like_cnt=" + like_cnt +
                ", comment_cnt=" + comment_cnt +
                '}';
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
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

    public CategorySelectResponseDto getCategory() {
        return category;
    }

    public void setCategory(CategorySelectResponseDto category) {
        this.category = category;
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

    public BoardSimpleInfo getPrevBoard() {
        return prevBoard;
    }

    public void setPrevBoard(BoardSimpleInfo prevBoard) {
        this.prevBoard = prevBoard;
    }

    public BoardSimpleInfo getNextBoard() {
        return nextBoard;
    }

    public void setNextBoard(BoardSimpleInfo nextBoard) {
        this.nextBoard = nextBoard;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public int getParticipant_cnt() {
        return participant_cnt;
    }

    public void setParticipant_cnt(int participant_cnt) {
        this.participant_cnt = participant_cnt;
    }

    public int getParticipant_limit() {
        return participant_limit;
    }

    public void setParticipant_limit(int participant_limit) {
        this.participant_limit = participant_limit;
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
