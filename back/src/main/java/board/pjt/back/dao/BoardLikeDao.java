package board.pjt.back.dao;

import board.pjt.back.common.constants.ErrorMessages;
import board.pjt.back.domain.ArticleLikeDto;
import board.pjt.back.domain.boardLike.BoardLikeListRequestDto;
import board.pjt.back.domain.boardLike.BoardLikeResponseDto;
import board.pjt.back.domain.boardLike.BoardToggleLikeRequestDto;
import board.pjt.back.mapper.BoardLikeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardLikeDao {

    private final BoardLikeMapper boardLikeMapper;

    public BoardLikeDao(BoardLikeMapper boardLikeMapper) {
        this.boardLikeMapper = boardLikeMapper;
    }

    public List<BoardLikeResponseDto> findByBoardLikeId(BoardLikeListRequestDto requestDto) {
        return boardLikeMapper.findByBoardLikeId(requestDto);
    }

    public int toggleBoardLike(BoardToggleLikeRequestDto requestDto) {
        Integer article_id = requestDto.getArticle_id();
        if (article_id == null) {
            throw new NullPointerException(ErrorMessages.ARTICLE_NOT_FOUND);
        }
        BoardLikeListRequestDto boardLikeListRequestDto = new BoardLikeListRequestDto();
        boardLikeListRequestDto.setArticle_id(article_id);
        List<BoardLikeResponseDto> boardLikeList = boardLikeMapper.findByBoardLikeId(boardLikeListRequestDto);
        boolean isLiked = boardLikeList.stream()
                .anyMatch(like -> like.getCreated_by().equals(requestDto.getCreated_by()));
        if (isLiked) {
            boardLikeMapper.delete(requestDto);
            return 0;
        } else {
            boardLikeMapper.insert(requestDto);
            return 1;
        }
    }

    public List<BoardLikeResponseDto> selectAll() {
        return boardLikeMapper.selectAll();
    }

    public ArticleLikeDto select(int article_like_id) {
        return boardLikeMapper.select(article_like_id);
    }


}
