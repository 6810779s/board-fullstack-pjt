package board.pjt.back.controller;

import board.pjt.back.dao.BoardDao;
import board.pjt.back.domain.board.BoardCreateRequestDto;
import board.pjt.back.domain.board.BoardDeleteRequestDto;
import board.pjt.back.domain.board.BoardResponseDto;
import board.pjt.back.domain.board.BoardUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class BoardController {
    @Autowired
    private BoardDao boardDao;

    @GetMapping("/")
    public ResponseEntity<List<BoardResponseDto>> getBoardList() {
        List<BoardResponseDto> boardList = boardDao.selectAll();
        return ResponseEntity.ok(boardList);
    }

    @GetMapping("/{article_id}")
    public ResponseEntity<BoardResponseDto> getBoard(@PathVariable Integer article_id) {
        BoardResponseDto board = boardDao.select(article_id);
        return ResponseEntity.ok(board);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createArticle(@RequestBody BoardCreateRequestDto requestDto) {
        try {
            boardDao.insert(requestDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // 예외 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteArticle(@RequestBody BoardDeleteRequestDto requestDto) {

        boardDao.delete(requestDto);
        return ResponseEntity.ok().build();

    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updateArticle(@RequestBody BoardUpdateRequestDto requestDto) {
        boardDao.update(requestDto);
        return ResponseEntity.ok().build();
    }
}
