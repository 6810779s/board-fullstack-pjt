package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.CommentLikeDao;
import board.pjt.back.domain.commentLike.CommentLikeListRequestDto;
import board.pjt.back.domain.commentLike.CommentLikeListResponseDto;
import board.pjt.back.domain.commentLike.CommentLikeToggleRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment-like")
public class CommentLikeController {
    private final CommentLikeDao commentLikeDao;

    public CommentLikeController(CommentLikeDao commentLikeDao) {
        this.commentLikeDao = commentLikeDao;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<CommentLikeListResponseDto>> getCommentLikeList(@RequestBody CommentLikeListRequestDto requestDto) {
        CommentLikeListResponseDto boardLikeListResponseDto = commentLikeDao.findByCommentId(requestDto);
        ApiResponse<CommentLikeListResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, boardLikeListResponseDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/toggle")
    public ResponseEntity<ApiResponse<Void>> toggleCommentLike(@RequestBody CommentLikeToggleRequestDto requestDto) {
        int status = commentLikeDao.toggleCommentLike(requestDto);
        ApiResponse<Void> response;
        if (status == 0) {
            response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        } else {
            response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        }
        return ResponseEntity.ok(response);
    }
}
