package board.pjt.back.dto.feedback;

import java.util.Objects;

public class FeedbackDeleteRequestDto {
    private long feedback_id;

    public FeedbackDeleteRequestDto() {
    }

    public FeedbackDeleteRequestDto(long feedback_id) {
        this.feedback_id = feedback_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackDeleteRequestDto that = (FeedbackDeleteRequestDto) o;
        return feedback_id == that.feedback_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback_id);
    }

    @Override
    public String toString() {
        return "FeedbackDeleteRequestDto{" +
                "feedback_id=" + feedback_id +
                '}';
    }

    public long getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(long feedback_id) {
        this.feedback_id = feedback_id;
    }
}
