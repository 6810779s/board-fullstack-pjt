package board.pjt.back.dto.friend;

import java.util.Objects;

public class DeleteFriendRequestDto {
    private String friend_email;

    public DeleteFriendRequestDto() {
    }

    public DeleteFriendRequestDto(String friend_email) {
        this.friend_email = friend_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteFriendRequestDto that = (DeleteFriendRequestDto) o;
        return Objects.equals(friend_email, that.friend_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend_email);
    }

    @Override
    public String toString() {
        return "DeleteFriendRequestDto{" +
                "friend_email='" + friend_email + '\'' +
                '}';
    }

    public String getFriend_email() {
        return friend_email;
    }

    public void setFriend_email(String friend_email) {
        this.friend_email = friend_email;
    }
}
