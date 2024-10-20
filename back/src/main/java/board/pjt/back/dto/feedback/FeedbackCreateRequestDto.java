package board.pjt.back.dto.feedback;

import java.util.Objects;

public class FeedbackCreateRequestDto {
    private String feedback_to_user_email;
    private String content;
    private int rating;
    private String created_by;

    public FeedbackCreateRequestDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackCreateRequestDto that = (FeedbackCreateRequestDto) o;
        return rating == that.rating && Objects.equals(feedback_to_user_email, that.feedback_to_user_email) && Objects.equals(content, that.content) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback_to_user_email, content, rating, created_by);
    }

    @Override
    public String toString() {
        return "FeedbackCreateRequestDto{" +
                "feedback_to_user_email='" + feedback_to_user_email + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public String getFeedback_to_user_email() {
        return feedback_to_user_email;
    }

    public void setFeedback_to_user_email(String feedback_to_user_email) {
        this.feedback_to_user_email = feedback_to_user_email;
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
}
