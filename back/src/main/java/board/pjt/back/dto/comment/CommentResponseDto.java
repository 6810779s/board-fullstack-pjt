package board.pjt.back.dto.comment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class CommentResponseDto {
    private long comment_id;
    private String content;
    private LocalDateTime created_at;
    private String nickname;
    private LocalDateTime updated_at;
    private int reply_comment_cnt;
    private int like_cnt;

    public CommentResponseDto() {
    }

    public CommentResponseDto(long comment_id, String content, LocalDateTime created_at, String nickname, LocalDateTime updated_at, int reply_comment_cnt, int like_cnt) {
        this.comment_id = comment_id;
        this.content = content;
        this.created_at = created_at;
        this.nickname = nickname;
        this.updated_at = updated_at;
        this.reply_comment_cnt = reply_comment_cnt;
        this.like_cnt = like_cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentResponseDto that = (CommentResponseDto) o;
        return comment_id == that.comment_id && reply_comment_cnt == that.reply_comment_cnt && like_cnt == that.like_cnt && Objects.equals(content, that.content) && Objects.equals(created_at, that.created_at) && Objects.equals(nickname, that.nickname) && Objects.equals(updated_at, that.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_id, content, created_at, nickname, updated_at, reply_comment_cnt, like_cnt);
    }

    @Override
    public String toString() {
        return "CommentResponseDto{" +
                "comment_id=" + comment_id +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                ", nickname='" + nickname + '\'' +
                ", updated_at=" + updated_at +
                ", reply_comment_cnt=" + reply_comment_cnt +
                ", like_cnt=" + like_cnt +
                '}';
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public int getReply_comment_cnt() {
        return reply_comment_cnt;
    }

    public void setReply_comment_cnt(int reply_comment_cnt) {
        this.reply_comment_cnt = reply_comment_cnt;
    }

    public int getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(int like_cnt) {
        this.like_cnt = like_cnt;
    }
}
