package board.pjt.back.dao;

import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.common.PaginationRequestDto;
import board.pjt.back.dto.friend.CreateFriendRequestDto;
import board.pjt.back.dto.friendRequest.FriendRequestCreateRequestDto;
import board.pjt.back.dto.friendRequest.FriendRequestDeleteRequestDto;
import board.pjt.back.dto.friendRequest.FriendRequestGetResponseDto;
import board.pjt.back.dto.friendRequest.FriendRequestUpdateRequestDto;
import board.pjt.back.enums.friendRequest.Status;
import board.pjt.back.mapper.FriendMapper;
import board.pjt.back.mapper.FriendRequestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRequestDao {
    private final FriendRequestMapper friendRequestMapper;
    private final FriendMapper friendMapper;
    public FriendRequestDao(FriendRequestMapper friendRequestMapper,FriendMapper friendMapper) {
        this.friendRequestMapper = friendRequestMapper;
        this.friendMapper = friendMapper;
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
        if(requestDto.getStatus() == Status.ACCEPTED){
            CreateFriendRequestDto createFriendRequestDto = new CreateFriendRequestDto();
//            createFriendRequestDto.setFriend_email(requestDto.get);
//            friendMapper.createFriend();
        }
        friendRequestMapper.updateFriendRequestStatus(requestDto);

    }
}
