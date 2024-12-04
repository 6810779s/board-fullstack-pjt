package board.pjt.back.dto.board;

import java.time.LocalDateTime;
import java.util.Objects;

public class BoardMainResponseDto {
    private String title;
    private String project_name;
    private String content;
    private int participant_cnt;
    private LocalDateTime created_at;
    private int like_cnt;
    private int comment_cnt;

    public BoardMainResponseDto() {
    }

    public BoardMainResponseDto(String title, String project_name, String content, int participant_cnt, LocalDateTime created_at, int like_cnt, int comment_cnt) {
        this.title = title;
        this.project_name = project_name;
        this.content = content;
        this.participant_cnt = participant_cnt;
        this.created_at = created_at;
        this.like_cnt = like_cnt;
        this.comment_cnt = comment_cnt;
    }

    @Override
    public String toString() {
        return "BoardListMainResponseDto{" +
                "title='" + title + '\'' +
                ", project_name='" + project_name + '\'' +
                ", content='" + content + '\'' +
                ", participant_cnt=" + participant_cnt +
                ", created_at=" + created_at +
                ", like_cnt=" + like_cnt +
                ", comment_cnt=" + comment_cnt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardMainResponseDto that = (BoardMainResponseDto) o;
        return participant_cnt == that.participant_cnt && like_cnt == that.like_cnt && comment_cnt == that.comment_cnt && Objects.equals(title, that.title) && Objects.equals(project_name, that.project_name) && Objects.equals(content, that.content) && Objects.equals(created_at, that.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, project_name, content, participant_cnt, created_at, like_cnt, comment_cnt);
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
