package board.pjt.back.dao;

import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.common.PaginationRequestDto;
import board.pjt.back.dto.friendRequest.FriendRequestCreateRequestDto;
import board.pjt.back.dto.friendRequest.FriendRequestDeleteRequestDto;
import board.pjt.back.dto.friendRequest.FriendRequestGetResponseDto;
import board.pjt.back.dto.friendRequest.FriendRequestUpdateRequestDto;
import board.pjt.back.mapper.FriendRequestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRequestDao {
    private final FriendRequestMapper friendRequestMapper;

    public FriendRequestDao(FriendRequestMapper friendRequestMapper) {
        this.friendRequestMapper = friendRequestMapper;
    }
    public void createFriendRequest(FriendRequestCreateRequestDto requestDto){
        friendRequestMapper.createFriendRequest(requestDto);
    }

    public PageHandler<FriendRequestGetResponseDto> getFriendRequest(String receiver_email, PaginationRequestDto requestDto){
        List<FriendRequestGetResponseDto> friendRequestList = friendRequestMapper.getFriendRequest(receiver_email);
        PageHandler<FriendRequestGetResponseDto> friendRequestGetResponseDtoPageHandler = new PageHandler<>(friendRequestList.size(),requestDto.getPage(), requestDto.getPageSize());
        friendRequestGetResponseDtoPageHandler.setContents(friendRequestList);
        return friendRequestGetResponseDtoPageHandler;
    }

    public void deleteFriendRequest(FriendRequestDeleteRequestDto requestDto){
        friendRequestMapper.deleteFriendRequest(requestDto);
    }

    public void updateFriendRequest(FriendRequestUpdateRequestDto requestDto){
        friendRequestMapper.updateFriendRequestStatus(requestDto);

    }
}
