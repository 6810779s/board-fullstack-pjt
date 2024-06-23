package board.pjt.back.dao;

import board.pjt.back.domain.BoardDto;
import board.pjt.back.mapper.BoardMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao implements BoardMapper {
    private final BoardMapper boardMapper;

    BoardDao(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public BoardDto select(int article_id) {
        return boardMapper.select(article_id);
    }

    public List<BoardDto> selectAll() {
        return boardMapper.selectAll();
    }

    public int update(BoardDto dto) {
        return boardMapper.update(dto);
    }

    public int insert(BoardDto dto) {
        return boardMapper.insert(dto);
    }

    public void deleteAll() {
        boardMapper.deleteAll();
    }

    public int delete(int article_id) {
        return boardMapper.delete(article_id);
    }


}
