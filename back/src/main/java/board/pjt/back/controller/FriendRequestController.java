package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.FriendRequestDao;
import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.common.PaginationRequestDto;
import board.pjt.back.dto.friendRequest.*;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend-request")
public class FriendRequestController {
    private final FriendRequestDao friendRequestDao;

    public FriendRequestController(FriendRequestDao friendRequestDao) {
        this.friendRequestDao = friendRequestDao;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createFriendRequest(@AuthenticationPrincipal UserDetails userDetails, @RequestBody FriendRequestCreateRequestDto requestDto){
        requestDto.setReceiver_email(userDetails.getUsername());
        friendRequestDao.createFriendRequest(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<PageHandler<FriendRequestGetResponseDto>>> getFriendRequest(@AuthenticationPrincipal UserDetails userDetails, @RequestBody PaginationRequestDto requestDto){
        PageHandler<FriendRequestGetResponseDto> friendRequestGetResponseDtoPageHandler = friendRequestDao.getFriendRequest(userDetails.getUsername(), requestDto);
        ApiResponse<PageHandler<FriendRequestGetResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, friendRequestGetResponseDtoPageHandler);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse<Void>> deleteFriendRequest(@AuthenticationPrincipal UserDetails userDetails, @RequestBody FriendRequestDeleteRequestDto requestDto){
        requestDto.setReceiver_email(userDetails.getUsername());
        friendRequestDao.deleteFriendRequest(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/status")
    public ResponseEntity<ApiResponse<Void>> updateFriendRequest(@AuthenticationPrincipal UserDetails userDetails, @RequestBody FriendRequestUpdateRequestDto requestDto){
        friendRequestDao.updateFriendRequest(userDetails, requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.UPDATE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sender-email")
    public ResponseEntity<ApiResponse<GetSenderEmailByFriendRequestIdResponseDto>> getSenderEmailByFriendRequestId(@RequestBody GetSenderEmailByFriendRequestIdRequestDto requestDto){
        GetSenderEmailByFriendRequestIdResponseDto senderEmail = friendRequestDao.getSenderEmailByFriendRequestId(requestDto);
        ApiResponse<GetSenderEmailByFriendRequestIdResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, senderEmail);
        return ResponseEntity.ok(response);
    }
}
