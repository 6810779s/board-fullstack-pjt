package board.pjt.back.dto.friendRequest;

import java.util.Objects;

public class GetSenderEmailByFriendRequestIdRequestDto {
    private int friend_request_id;

    public GetSenderEmailByFriendRequestIdRequestDto() {
    }

    public GetSenderEmailByFriendRequestIdRequestDto(int friend_request_id) {
        this.friend_request_id = friend_request_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetSenderEmailByFriendRequestIdRequestDto that = (GetSenderEmailByFriendRequestIdRequestDto) o;
        return friend_request_id == that.friend_request_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend_request_id);
    }

    @Override
    public String toString() {
        return "GetEmailByFriendRequestIdRequestDto{" +
                "friend_request_id=" + friend_request_id +
                '}';
    }

    public int getFriend_request_id() {
        return friend_request_id;
    }

    public void setFriend_request_id(int friend_request_id) {
        this.friend_request_id = friend_request_id;
    }
}
