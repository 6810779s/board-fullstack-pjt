package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.BoardDao;
import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.board.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class BoardController {
    private final BoardDao boardDao;


    public BoardController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<BoardResponseDto>>> getBoardList() {
        List<BoardResponseDto> boardList = boardDao.selectAll();
        ApiResponse<List<BoardResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, boardList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pagination")
    public ResponseEntity<ApiResponse<PageHandler<BoardResponseDto>>> getBoardListPagination(@RequestBody BoardPaginationRequestDto requestDto) {
        PageHandler<BoardResponseDto> boardListPagination = boardDao.boardPagination(requestDto);
        ApiResponse<PageHandler<BoardResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, boardListPagination);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{article_id}")
    public ResponseEntity<ApiResponse<BoardResponseDto>> getBoard(@PathVariable Integer article_id) {
        BoardResponseDto board = boardDao.select(article_id);
        ApiResponse<BoardResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, board);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createArticle(@RequestBody BoardCreateRequestDto requestDto) {
        boardDao.insert(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<Void>> deleteArticle(@RequestBody BoardDeleteRequestDto requestDto) {
        boardDao.delete(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);

    }

    @PatchMapping("/update")
    public ResponseEntity<ApiResponse<Void>> updateArticle(@RequestBody BoardUpdateRequestDto requestDto) {
        boardDao.update(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.UPDATE_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
