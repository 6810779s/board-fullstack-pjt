package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.FriendDao;
import board.pjt.back.dto.friend.CreateFriendRequestDto;
import board.pjt.back.dto.friend.DeleteFriendRequestDto;
import board.pjt.back.dto.friend.GetFriendResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {
    private final FriendDao friendDao;

    public FriendController(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createFriend(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CreateFriendRequestDto requestDto){
        requestDto.setCreated_by(userDetails.getUsername());
        friendDao.createFriend(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<GetFriendResponseDto>>> getFriend(@AuthenticationPrincipal UserDetails userDetails){
        List<GetFriendResponseDto> friendList = friendDao.getFriend(userDetails.getUsername());
        ApiResponse<List<GetFriendResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, friendList);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse<Void>> deleteFriend(@RequestBody DeleteFriendRequestDto requestDto){
        friendDao.deleteFriend(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
