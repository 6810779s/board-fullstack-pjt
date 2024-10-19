package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.CommentLikeDao;
import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.commentLike.CommentLikeListRequestDto;
import board.pjt.back.dto.commentLike.CommentLikeListResponseDto;
import board.pjt.back.dto.commentLike.CommentLikeResponseDto;
import board.pjt.back.dto.commentLike.CommentLikeToggleRequestDto;
import board.pjt.back.dto.common.PaginationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment-like")
public class CommentLikeController {
    private final CommentLikeDao commentLikeDao;

    public CommentLikeController(CommentLikeDao commentLikeDao) {
        this.commentLikeDao = commentLikeDao;
    }

//    해당 부분에서 join을 제대로 적용시키지 않음
//    join을 적용시키고 싶을 시, comment_like 리스트를 받을 수 있는 관련 sql문을 따로 빼줘서 관리해야됨
    @GetMapping("/")
    public ResponseEntity<ApiResponse<CommentLikeListResponseDto>> getCommentLikeList(@RequestBody CommentLikeListRequestDto requestDto) {
        CommentLikeListResponseDto boardLikeListResponseDto = commentLikeDao.findByCommentId(requestDto);
        ApiResponse<CommentLikeListResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, boardLikeListResponseDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pagination/my-list")
    public ResponseEntity<ApiResponse<PageHandler<CommentLikeResponseDto>>> getMyCommentLikeList(@AuthenticationPrincipal UserDetails userDetails, @RequestBody PaginationRequestDto requestDto) {
        PageHandler<CommentLikeResponseDto> commentLikeResponseDtoPageHandler = commentLikeDao.myCommentLikePagination(userDetails, requestDto);
        ApiResponse<PageHandler<CommentLikeResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, commentLikeResponseDtoPageHandler);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/toggle")
    public ResponseEntity<ApiResponse<Void>> toggleCommentLike(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CommentLikeToggleRequestDto requestDto) {
        int status = commentLikeDao.toggleCommentLike(userDetails, requestDto);
        ApiResponse<Void> response;
        if (status == 0) {
            response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        } else {
            response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        }
        return ResponseEntity.ok(response);
    }
}
