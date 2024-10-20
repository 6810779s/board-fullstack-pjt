package board.pjt.back.dto.feedback;

import java.util.Objects;

public class FeedbackGetListResponseDto {
    private int feedback_id;
    private String content;
    private int rating;
    private String created_by;

    public FeedbackGetListResponseDto() {
    }

    public FeedbackGetListResponseDto(int feedback_id, String content, int rating, String created_by) {
        this.feedback_id = feedback_id;
        this.content = content;
        this.rating = rating;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackGetListResponseDto that = (FeedbackGetListResponseDto) o;
        return feedback_id == that.feedback_id && rating == that.rating && Objects.equals(content, that.content) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback_id, content, rating, created_by);
    }

    @Override
    public String toString() {
        return "FeedbackGetListResponseDto{" +
                "feedback_id=" + feedback_id +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", created_by='" + created_by + '\'' +
                '}';
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

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }
}
