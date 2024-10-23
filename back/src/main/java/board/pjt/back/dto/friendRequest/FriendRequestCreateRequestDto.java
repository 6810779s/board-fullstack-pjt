package board.pjt.back.dto.friendRequest;

import board.pjt.back.enums.friendRequest.Status;

import java.util.Objects;

public class FriendRequestCreateRequestDto {
    private String receiver_email;
    private String sender_email;
    private Status status;

    public FriendRequestCreateRequestDto() {
        this.status = Status.PENDING;

    }

    public FriendRequestCreateRequestDto(String receiver_email, String sender_email, Status status) {
        this.receiver_email = receiver_email;
        this.sender_email = sender_email;
        this.status = Status.PENDING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendRequestCreateRequestDto that = (FriendRequestCreateRequestDto) o;
        return Objects.equals(receiver_email, that.receiver_email) && Objects.equals(sender_email, that.sender_email) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiver_email, sender_email, status);
    }

    @Override
    public String toString() {
        return "FriendRequestCreateRequestDto{" +
                "receiver_email='" + receiver_email + '\'' +
                ", sender_email='" + sender_email + '\'' +
                ", status=" + status +
                '}';
    }

    public String getReceiver_email() {
        return receiver_email;
    }

    public void setReceiver_email(String receiver_email) {
        this.receiver_email = receiver_email;
    }

    public String getSender_email() {
        return sender_email;
    }

    public void setSender_email(String sender_email) {
        this.sender_email = sender_email;
    }

    public Status getStatus() {
        return status;
    }

    // status를 외부에서 설정하지 않도록 Setter는 필요 없음 또는 private으로 설정
    private void setStatus(Status status) {
        this.status = status;
    }
}
