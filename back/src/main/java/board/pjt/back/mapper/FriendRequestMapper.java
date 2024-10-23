package board.pjt.back.mapper;

import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.friendRequest.FriendRequestCreateRequestDto;
import board.pjt.back.dto.friendRequest.FriendRequestDeleteRequestDto;
import board.pjt.back.dto.friendRequest.FriendRequestGetResponseDto;
import board.pjt.back.dto.friendRequest.FriendRequestUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendRequestMapper {
    void createFriendRequest(FriendRequestCreateRequestDto dto);

    List<FriendRequestGetResponseDto> getFriendRequest(String receiver_email);

    void deleteFriendRequest(FriendRequestDeleteRequestDto dto);
void updateFriendRequestStatus(FriendRequestUpdateRequestDto dto);
}
