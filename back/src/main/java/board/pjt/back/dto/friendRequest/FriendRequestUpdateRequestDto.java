package board.pjt.back.dto.friendRequest;

import board.pjt.back.enums.friendRequest.Status;

import java.util.Objects;

public class FriendRequestUpdateRequestDto {
    private int friend_request_id;
    private Status status;

    public FriendRequestUpdateRequestDto() {
    }

    public FriendRequestUpdateRequestDto(int friend_request_id, Status status) {
        this.friend_request_id = friend_request_id;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendRequestUpdateRequestDto that = (FriendRequestUpdateRequestDto) o;
        return friend_request_id == that.friend_request_id && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend_request_id, status);
    }

    @Override
    public String toString() {
        return "FriendRequestUpdateRequestDto{" +
                "friend_request_id=" + friend_request_id +
                ", status=" + status +
                '}';
    }

    public int getFriend_request_id() {
        return friend_request_id;
    }

    public void setFriend_request_id(int friend_request_id) {
        this.friend_request_id = friend_request_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
