package board.pjt.back.dao;

import board.pjt.back.domain.BoardDto;
import board.pjt.back.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardDao {
    private final BoardMapper boardMapper;

    BoardDao(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    BoardDto select(int article_id) {
        return boardMapper.select(article_id);
    }

    List<BoardDto> selectAll() {
        return boardMapper.selectAll();
    }

    int update(BoardDto dto) {
        return boardMapper.update(dto);
    }

    int insert(BoardDto dto) {
        return boardMapper.insert(dto);
    }

    void deleteAll() {
        boardMapper.deleteAll();
    }

    int delete(int article_id) {
        return boardMapper.delete(article_id);
    }


}
