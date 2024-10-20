package board.pjt.back.dto.feedback;

import java.util.Objects;

public class FeedbackGetListRequestDto {
    private String feedback_to_user_email;

    public FeedbackGetListRequestDto() {
    }

    public FeedbackGetListRequestDto(String feedback_to_user_email) {
        this.feedback_to_user_email = feedback_to_user_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackGetListRequestDto that = (FeedbackGetListRequestDto) o;
        return Objects.equals(feedback_to_user_email, that.feedback_to_user_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback_to_user_email);
    }

    @Override
    public String toString() {
        return "FeedbackGetListRequestDto{" +
                "feedback_to_user_email='" + feedback_to_user_email + '\'' +
                '}';
    }

    public String getFeedback_to_user_email() {
        return feedback_to_user_email;
    }

    public void setFeedback_to_user_email(String feedback_to_user_email) {
        this.feedback_to_user_email = feedback_to_user_email;
    }
}
