package board.pjt.back.dto.friend;

import java.util.Objects;

public class CreateFriendRequestDto {
    private String friend_email;
    private String created_by;

    public CreateFriendRequestDto() {
    }

    public CreateFriendRequestDto(String friend_email, String created_by) {
        this.friend_email = friend_email;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateFriendRequestDto that = (CreateFriendRequestDto) o;
        return Objects.equals(friend_email, that.friend_email) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend_email, created_by);
    }

    @Override
    public String toString() {
        return "CreateFriendRequestDto{" +
                "friend_email='" + friend_email + '\'' +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public String getFriend_email() {
        return friend_email;
    }

    public void setFriend_email(String friend_email) {
        this.friend_email = friend_email;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
