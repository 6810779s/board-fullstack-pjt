package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.ArticleCommentsDao;
import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.comment.*;
import board.pjt.back.dto.common.PaginationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ArticleCommentsDao commentsDao;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<CommentResponseDto>>> commentList() {
        List<CommentResponseDto> commentList = commentsDao.selectAll();
        ApiResponse<List<CommentResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, commentList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pagination/my-list")
    public ResponseEntity<ApiResponse<PageHandler<CommentResponseDto>>> myCommentList(@AuthenticationPrincipal UserDetails userDetails, @RequestBody PaginationRequestDto requestDto) {
        PageHandler<CommentResponseDto> commentList = commentsDao.myCommentPagination(userDetails, requestDto);
        ApiResponse<PageHandler<CommentResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, commentList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail")
    public ResponseEntity<ApiResponse<CommentResponseDto>> commentDetail(@RequestBody CommentDetailRequestDto requestDto) {
        CommentResponseDto comment = commentsDao.select(requestDto);
        ApiResponse<CommentResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, comment);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/reply_comment")
    public ResponseEntity<ApiResponse<List<CommentResponseDto>>> selectAllReplyComment(@RequestBody CommentReplyRequestDto requestDto) {
        List<CommentResponseDto> replyComment = commentsDao.selectAllReplyList(requestDto);
        ApiResponse<List<CommentResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, replyComment);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/article/{article_id}")
    public ResponseEntity<ApiResponse<List<CommentResponseDto>>> commentListByArticleId(@PathVariable Integer article_id) {
        List<CommentResponseDto> commentList = commentsDao.selectAllCommentByArticleId(article_id);
        ApiResponse<List<CommentResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, commentList);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createComment(@RequestBody CommentCreateRequestDto requestDto) {
        commentsDao.insert(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<Void>> deleteComment(@RequestBody CommentDeleteRequestDto requestDto) {
        commentsDao.delete(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update")
    public ResponseEntity<ApiResponse<Void>> updateComment(@RequestBody CommentUpdateRequestDto requestDto) {
        commentsDao.update(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.UPDATE_SUCCESS);
        return ResponseEntity.ok(response);
    }


}
