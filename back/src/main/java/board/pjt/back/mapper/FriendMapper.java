package board.pjt.back.mapper;

import board.pjt.back.dto.friend.CreateFriendRequestDto;
import board.pjt.back.dto.friend.DeleteFriendRequestDto;
import board.pjt.back.dto.friend.GetFriendResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendMapper {
    void createFriend(CreateFriendRequestDto dto);
    List<GetFriendResponseDto> getFriend(String created_by);

    void deleteFriend(DeleteFriendRequestDto dto);
}
