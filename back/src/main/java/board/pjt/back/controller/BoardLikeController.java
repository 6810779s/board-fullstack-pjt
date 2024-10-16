package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.BoardLikeDao;
import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.boardLike.BoardLikeListRequestDto;
import board.pjt.back.dto.boardLike.BoardLikeListResponseDto;
import board.pjt.back.dto.boardLike.BoardLikeResponseDto;
import board.pjt.back.dto.boardLike.BoardToggleLikeRequestDto;
import board.pjt.back.dto.common.PaginationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board-like")
public class BoardLikeController {
    private final BoardLikeDao boardLikeDao;

    public BoardLikeController(BoardLikeDao boardLikeDao) {
        this.boardLikeDao = boardLikeDao;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<BoardLikeListResponseDto>> getBoardLikeList(@RequestBody BoardLikeListRequestDto requestDto) {
        BoardLikeListResponseDto boardLikeList = boardLikeDao.findByBoardLikeId(requestDto);
        ApiResponse<BoardLikeListResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, boardLikeList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pagination/my-list")
    public ResponseEntity<ApiResponse<PageHandler<BoardLikeResponseDto>>> getBoardLikeList(@AuthenticationPrincipal UserDetails userDetails, @RequestBody PaginationRequestDto requestDto) {
        PageHandler<BoardLikeResponseDto> boardLikeList = boardLikeDao.myBoardLikePagination(userDetails, requestDto);
        ApiResponse<PageHandler<BoardLikeResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, boardLikeList);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/toggle")
    public ResponseEntity<ApiResponse<Void>> toggleBoardLike(@AuthenticationPrincipal UserDetails userDetails, @RequestBody BoardToggleLikeRequestDto requestDto) {
        int status = boardLikeDao.toggleBoardLike(userDetails, requestDto);
        ApiResponse<Void> response;
        if (status == 0) {
            response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        } else {
            response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        }
        return ResponseEntity.ok(response);

    }
}
