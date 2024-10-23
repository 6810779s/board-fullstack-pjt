package board.pjt.back.dto.friendRequest;

import java.util.Objects;

public class GetSenderEmailByFriendRequestIdResponseDto {
    private String sender_email;

    public GetSenderEmailByFriendRequestIdResponseDto() {
    }

    public GetSenderEmailByFriendRequestIdResponseDto(String sender_email) {
        this.sender_email = sender_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetSenderEmailByFriendRequestIdResponseDto that = (GetSenderEmailByFriendRequestIdResponseDto) o;
        return Objects.equals(sender_email, that.sender_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender_email);
    }

    @Override
    public String toString() {
        return "GetSenderEmailByFriendRequestResponseDto{" +
                "sender_email='" + sender_email + '\'' +
                '}';
    }

    public String getSender_email() {
        return sender_email;
    }

    public void setSender_email(String sender_email) {
        this.sender_email = sender_email;
    }
}
