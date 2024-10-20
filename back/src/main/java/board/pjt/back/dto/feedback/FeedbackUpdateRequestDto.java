package board.pjt.back.dto.feedback;

import java.util.Objects;

public class FeedbackUpdateRequestDto {
    private int feedback_id;
    private String content;
    private int rating;

    public FeedbackUpdateRequestDto() {
    }

    public FeedbackUpdateRequestDto(int feedback_id, String content, int rating) {
        this.feedback_id = feedback_id;
        this.content = content;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackUpdateRequestDto that = (FeedbackUpdateRequestDto) o;
        return feedback_id == that.feedback_id && rating == that.rating && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback_id, content, rating);
    }

    @Override
    public String toString() {
        return "FeedbackUpdateRequestDto{" +
                "feedback_id=" + feedback_id +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                '}';
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
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
}
