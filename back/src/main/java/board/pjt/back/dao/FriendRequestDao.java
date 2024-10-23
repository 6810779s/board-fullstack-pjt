package board.pjt.back.dao;

import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.common.PaginationRequestDto;
import board.pjt.back.dto.friend.CreateFriendRequestDto;
import board.pjt.back.dto.friendRequest.*;
import board.pjt.back.enums.friendRequest.Status;
import board.pjt.back.mapper.FriendMapper;
import board.pjt.back.mapper.FriendRequestMapper;
import org.springframework.security.core.userdetails.UserDetails;
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

    public GetSenderEmailByFriendRequestIdResponseDto getSenderEmailByFriendRequestId(GetSenderEmailByFriendRequestIdRequestDto requestDto){
        return friendRequestMapper.getSenderEmailByFriendRequestId(requestDto);
    }

    public void updateFriendRequest(UserDetails userDetails, FriendRequestUpdateRequestDto requestDto){
        // senderEmail 찾는 로직
        GetSenderEmailByFriendRequestIdRequestDto senderEmailRequestDto = new GetSenderEmailByFriendRequestIdRequestDto();
        senderEmailRequestDto.setFriend_request_id(requestDto.getFriend_request_id());
        GetSenderEmailByFriendRequestIdResponseDto senderEmailResponseDto = getSenderEmailByFriendRequestId(senderEmailRequestDto);

        // 로그인한 유저 email
        String userEmail = userDetails.getUsername();

        //데이터 삭제시 필요한 requestDto
        FriendRequestDeleteRequestDto deleteRequestDto = new FriendRequestDeleteRequestDto();
        deleteRequestDto.setReceiver_email(userEmail);
        deleteRequestDto.setFriend_request_id(requestDto.getFriend_request_id());

        if(requestDto.getStatus() == Status.ACCEPTED && senderEmailResponseDto != null){
            CreateFriendRequestDto createFriendRequestDto = new CreateFriendRequestDto();
            createFriendRequestDto.setCreated_by(userEmail);
            createFriendRequestDto.setFriend_email(senderEmailResponseDto.getSender_email());
            friendMapper.createFriend(createFriendRequestDto);
            friendRequestMapper.deleteFriendRequest(deleteRequestDto);
        } else if (requestDto.getStatus() == Status.CANCELED || requestDto.getStatus()==Status.REJECTED) {
            friendRequestMapper.deleteFriendRequest(deleteRequestDto);
        }else{
            friendRequestMapper.updateFriendRequestStatus(requestDto);
        }
        // 추후 차단 Status.BLOCKED 일때 조건도 필요.

    }
}
