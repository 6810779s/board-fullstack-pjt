package board.pjt.back.dao;

import board.pjt.back.common.constants.ErrorMessages;
import board.pjt.back.domain.PageHandler;
import board.pjt.back.domain.board.*;
import board.pjt.back.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardDao {
    private final BoardMapper boardMapper;

    public BoardDao(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public PageHandler<BoardResponseDto> boardPagination(BoardPaginationRequestDto requestDto) {
        List<BoardResponseDto> boardList = boardMapper.selectAll();
        PageHandler<BoardResponseDto> boardResponseDtoPageHandler = new PageHandler<>(boardList.size(), requestDto.getPage(), requestDto.getPageSize());
        boardResponseDtoPageHandler.setContents(boardList);
        return boardResponseDtoPageHandler;
    }

    public BoardResponseDto select(Integer article_id) {
        BoardResponseDto dto = boardMapper.select(article_id);
        if (dto == null) {
            throw new IllegalArgumentException(ErrorMessages.ARTICLE_NOT_FOUND);
        }
        return dto;
    }

    public List<BoardResponseDto> selectAll() {
        return boardMapper.selectAll();
    }

    public void insert(BoardCreateRequestDto requestDto) {
        // TODO: category id 여부 체크
        boardMapper.insert(requestDto);
    }

    public void delete(BoardDeleteRequestDto requestDto) {
        BoardResponseDto board = select(requestDto.getArticle_id());
        if (board == null) {
            throw new IllegalArgumentException(ErrorMessages.ARTICLE_NOT_FOUND);
        }
        boardMapper.delete(requestDto);
//        BoardResponseDto deletedBoard = select(requestDto.getArticle_id());
//        if (deletedBoard != null) {
//            throw new RuntimeException(requestDto.getArticle_id() + "번의 게시글이 삭제되지 않았습니다.");
//        }
    }

    public void update(BoardUpdateRequestDto requestDto) {
        BoardResponseDto board = select(requestDto.getArticle_id());
        if (board == null) {
            throw new IllegalArgumentException(ErrorMessages.ARTICLE_NOT_FOUND);
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
