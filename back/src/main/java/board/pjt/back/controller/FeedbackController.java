package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.FeedbackDao;
import board.pjt.back.dto.feedback.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackDao feedbackDao;

    public FeedbackController(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<FeedbackGetListResponseDto>>> getFeedbackListByToUserEmail(@AuthenticationPrincipal UserDetails userDetails, @RequestBody FeedbackGetListRequestDto requestDto){
        requestDto.setFeedback_to_user_email(userDetails.getUsername());
        List<FeedbackGetListResponseDto> feedbackList = feedbackDao.getFeedbackListByToUserEmail(requestDto);
        ApiResponse<List<FeedbackGetListResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, feedbackList);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> getFeedbackListByToUserEmail(@AuthenticationPrincipal UserDetails userDetails,@RequestBody FeedbackCreateRequestDto requestDto){
        requestDto.setCreated_by(userDetails.getUsername());
        feedbackDao.createFeedback(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse<Void>> deleteFeedbackById(@RequestBody FeedbackDeleteRequestDto requestDto){
        feedbackDao.deleteFeedbackById(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/")
    public ResponseEntity<ApiResponse<Void>> updateFeedbackByFeedbackId(@RequestBody FeedbackUpdateRequestDto requestDto){
        feedbackDao.updateFeedbackByFeedbackId(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.UPDATE_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
