package board.pjt.back.dto.friendRequest;

import board.pjt.back.dto.friend.FriendDto;
import board.pjt.back.enums.friendRequest.Status;

import java.util.Objects;

public class FriendRequestGetResponseDto {
    private int friend_request_id;
    private String sender_email;
    private FriendDto friendDto;
    private Status status;

    public FriendRequestGetResponseDto() {
    }

    public FriendRequestGetResponseDto(int friend_request_id, String sender_email, FriendDto friendDto, Status status) {
        this.friend_request_id = friend_request_id;
        this.sender_email = sender_email;
        this.friendDto = friendDto;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendRequestGetResponseDto that = (FriendRequestGetResponseDto) o;
        return friend_request_id == that.friend_request_id && Objects.equals(sender_email, that.sender_email) && Objects.equals(friendDto, that.friendDto) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend_request_id, sender_email, friendDto, status);
    }

    @Override
    public String toString() {
        return "FriendRequestGetResponseDto{" +
                "friend_request_id=" + friend_request_id +
                ", sender_email='" + sender_email + '\'' +
                ", friendDto=" + friendDto +
                ", status=" + status +
                '}';
    }

    public int getFriend_request_id() {
        return friend_request_id;
    }

    public void setFriend_request_id(int friend_request_id) {
        this.friend_request_id = friend_request_id;
    }

    public String getSender_email() {
        return sender_email;
    }

    public void setSender_email(String sender_email) {
        this.sender_email = sender_email;
    }

    public FriendDto getFriendDto() {
        return friendDto;
    }

    public void setFriendDto(FriendDto friendDto) {
        this.friendDto = friendDto;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
