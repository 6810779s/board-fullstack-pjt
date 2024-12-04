package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.BoardDao;
import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.board.*;
import board.pjt.back.dto.common.PaginationRequestDto;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
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

    @GetMapping("/criteria")
    public ResponseEntity<ApiResponse<List<BoardMainResponseDto>>> getBoardMainList(@ModelAttribute BoardMainRequestDto requestDto){
        Map<String, Object> params = new HashMap<>();
        params.put("searchType", requestDto.getSearchType().name());
        params.put("keyword", requestDto.getKeyword());

        List<BoardMainResponseDto> boardMainList = boardDao.getBoardByCriteria(params);
        ApiResponse<List<BoardMainResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, boardMainList);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/pagination")
    public ResponseEntity<ApiResponse<PageHandler<BoardResponseDto>>> getBoardListPagination(@ModelAttribute PaginationRequestDto requestDto) {
        PageHandler<BoardResponseDto> boardListPagination = boardDao.boardPagination(requestDto);
        ApiResponse<PageHandler<BoardResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, boardListPagination);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pagination/my-list")
    public ResponseEntity<ApiResponse<PageHandler<BoardResponseDto>>> getMyBoardListPagination(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute PaginationRequestDto requestDto) {
        System.out.println("PaginationRequestDto="+requestDto.toString());
        PageHandler<BoardResponseDto> myBoardListPagination = boardDao.myBoardPagination(userDetails, requestDto);
        ApiResponse<PageHandler<BoardResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, myBoardListPagination);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{board_id}")
    public ResponseEntity<ApiResponse<BoardDetailResponseDto>> getBoard(@PathVariable long board_id) {
        BoardDetailResponseDto board = boardDao.select(board_id);
        ApiResponse<BoardDetailResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, board);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createBoard(@RequestBody BoardCreateRequestDto requestDto) {
        boardDao.insert(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<Void>> deleteBoard(@RequestBody BoardDeleteRequestDto requestDto) {
        boardDao.delete(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update")
    public ResponseEntity<ApiResponse<Void>> updateBoard(@RequestBody BoardUpdateRequestDto requestDto) {
        boardDao.update(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.UPDATE_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
