package board.pjt.back.dao;

import board.pjt.back.domain.board.BoardCreateRequestDto;
import board.pjt.back.domain.board.BoardDeleteRequestDto;
import board.pjt.back.domain.board.BoardResponseDto;
import board.pjt.back.domain.board.BoardUpdateRequestDto;
import board.pjt.back.mapper.BoardMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao implements BoardMapper {
    private final BoardMapper boardMapper;

    public BoardDao(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public BoardResponseDto select(Integer article_id) {

        return boardMapper.select(article_id);
    }

    @Override
    public List<BoardResponseDto> selectAll() {
        return boardMapper.selectAll();
    }

    @Override
    public void insert(BoardCreateRequestDto requestDto) {
        boardMapper.insert(requestDto);
    }

    @Override
    public void delete(BoardDeleteRequestDto requestDto) {
        BoardResponseDto board = select(requestDto.getArticle_id());
        if (board == null) {
            throw new IllegalArgumentException(requestDto.getArticle_id() + "번의 게시글이 존재하지 않습니다.");
        }
        boardMapper.delete(requestDto);
        BoardResponseDto deletedBoard = select(requestDto.getArticle_id());
        if (deletedBoard != null) {
            throw new RuntimeException(requestDto.getArticle_id() + "번의 게시글이 삭제되지 않았습니다.");
        }
    }

    @Override
    public void update(BoardUpdateRequestDto requestDto) {
        BoardResponseDto board = select(requestDto.getArticle_id());
        if (board == null) {
            throw new IllegalArgumentException(requestDto.getArticle_id() + "번의 게시글이 존재하지 않습니다.");
        }
        // [TODO] category_id에서 category가 category 목록에 포함 되어있는지 확인하는 로직 구현 필요
        boardMapper.update(requestDto);
        BoardResponseDto updateBoard = select(requestDto.getArticle_id());

        if (updateBoard == null ||
                !updateBoard.getTitle().equals(requestDto.getTitle()) ||
                !updateBoard.getContent().equals(requestDto.getContent()) ||
                !updateBoard.getCategory_id().equals(requestDto.getCategory_id())) {
            throw new RuntimeException(requestDto.getArticle_id() + "번의 게시글이 업데이트되지 않았습니다.");
        }

    }


}
