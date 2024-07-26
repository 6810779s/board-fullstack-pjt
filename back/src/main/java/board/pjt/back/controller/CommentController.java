package board.pjt.back.controller;

import board.pjt.back.dao.ArticleCommentsDao;
import board.pjt.back.domain.comment.CommentCreateRequestDto;
import board.pjt.back.domain.comment.CommentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ArticleCommentsDao commentsDao;

    @GetMapping("/")
    public ResponseEntity<List<CommentResponseDto>> commentList() {
        List<CommentResponseDto> commentList = commentsDao.selectAll();
        return ResponseEntity.ok(commentList);
    }

    @GetMapping("/{comment_id}")
    public ResponseEntity<CommentResponseDto> commentDetail(@PathVariable Integer comment_id) {
        CommentResponseDto comment = commentsDao.select(comment_id);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createComment(@RequestBody CommentCreateRequestDto requestDto) {
        System.out.println("??requestDto=" + requestDto);
        commentsDao.insert(requestDto);
        return ResponseEntity.ok().build();
    }
}
