package board.pjt.back.dao;

import board.pjt.back.dto.friend.CreateFriendRequestDto;
import board.pjt.back.dto.friend.DeleteFriendRequestDto;
import board.pjt.back.dto.friend.GetFriendResponseDto;
import board.pjt.back.mapper.FriendMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendDao {
    private final FriendMapper friendMapper;

    public FriendDao(FriendMapper friendMapper) {
        this.friendMapper = friendMapper;
    }

    public void createFriend(CreateFriendRequestDto requestDto){
        friendMapper.createFriend(requestDto);
    }

    public List<GetFriendResponseDto> getFriend(String created_by){
        return friendMapper.getFriend(created_by);
    }

    public void deleteFriend(DeleteFriendRequestDto requestDto){
        friendMapper.deleteFriend(requestDto);
    }
}
