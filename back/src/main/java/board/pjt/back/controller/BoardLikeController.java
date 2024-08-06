package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.BoardLikeDao;
import board.pjt.back.domain.boardLike.BoardLikeListRequestDto;
import board.pjt.back.domain.boardLike.BoardLikeResponseDto;
import board.pjt.back.domain.boardLike.BoardToggleLikeRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board-like")
public class BoardLikeController {
    private final BoardLikeDao boardLikeDao;

    public BoardLikeController(BoardLikeDao boardLikeDao) {
        this.boardLikeDao = boardLikeDao;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<BoardLikeResponseDto>>> getBoardLikeList(@RequestBody BoardLikeListRequestDto requestDto) {
        List<BoardLikeResponseDto> boardLikeList = boardLikeDao.findByBoardLikeId(requestDto);
        ApiResponse<List<BoardLikeResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, boardLikeList);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/toggle")
    public ResponseEntity<ApiResponse<Void>> toggleBoardLike(@RequestBody BoardToggleLikeRequestDto requestDto) {
        int status = boardLikeDao.toggleBoardLike(requestDto);
        ApiResponse<Void> response;
        if (status == 0) {
            response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        } else {
            response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        }
        return ResponseEntity.ok(response);

    }
}
