package board.pjt.back.dto.friendRequest;

import java.util.Objects;

public class FriendRequestDeleteRequestDto {
    private int friend_request_id;
    private String receiver_email;

    public FriendRequestDeleteRequestDto() {
    }

    public FriendRequestDeleteRequestDto(int friend_request_id, String receiver_email) {
        this.friend_request_id = friend_request_id;
        this.receiver_email = receiver_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendRequestDeleteRequestDto that = (FriendRequestDeleteRequestDto) o;
        return friend_request_id == that.friend_request_id && Objects.equals(receiver_email, that.receiver_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend_request_id, receiver_email);
    }

    @Override
    public String toString() {
        return "FriendRequestDeleteRequestDto{" +
                "friend_request_id=" + friend_request_id +
                ", receiver_email='" + receiver_email + '\'' +
                '}';
    }

    public int getFriend_request_id() {
        return friend_request_id;
    }

    public void setFriend_request_id(int friend_request_id) {
        this.friend_request_id = friend_request_id;
    }

    public String getReceiver_email() {
        return receiver_email;
    }

    public void setReceiver_email(String receiver_email) {
        this.receiver_email = receiver_email;
    }
}
