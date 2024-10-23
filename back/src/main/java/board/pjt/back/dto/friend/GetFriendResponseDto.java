package board.pjt.back.dto.friend;

import java.util.Objects;

public class GetFriendResponseDto {
    private String friend_email;
    private FriendDto friendDto;

    public GetFriendResponseDto() {
    }

    public GetFriendResponseDto(String friend_email, FriendDto friendDto) {
        this.friend_email = friend_email;
        this.friendDto = friendDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetFriendResponseDto that = (GetFriendResponseDto) o;
        return Objects.equals(friend_email, that.friend_email) && Objects.equals(friendDto, that.friendDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend_email, friendDto);
    }

    @Override
    public String toString() {
        return "GetFriendResponseDto{" +
                "friend_email='" + friend_email + '\'' +
                ", friendDto=" + friendDto +
                '}';
    }

    public String getFriend_email() {
        return friend_email;
    }

    public void setFriend_email(String friend_email) {
        this.friend_email = friend_email;
    }

    public FriendDto getFriendDto() {
        return friendDto;
    }

    public void setFriendDto(FriendDto friendDto) {
        this.friendDto = friendDto;
    }
}
