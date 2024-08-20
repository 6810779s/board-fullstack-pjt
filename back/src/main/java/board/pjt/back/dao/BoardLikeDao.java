package board.pjt.back.dao;

import board.pjt.back.common.constants.ErrorMessages;
import board.pjt.back.dto.ArticleLikeDto;
import board.pjt.back.dto.boardLike.BoardLikeListRequestDto;
import board.pjt.back.dto.boardLike.BoardLikeListResponseDto;
import board.pjt.back.dto.boardLike.BoardLikeResponseDto;
import board.pjt.back.dto.boardLike.BoardToggleLikeRequestDto;
import board.pjt.back.mapper.BoardLikeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardLikeDao {

    private final BoardLikeMapper boardLikeMapper;

    public BoardLikeDao(BoardLikeMapper boardLikeMapper) {
        this.boardLikeMapper = boardLikeMapper;
    }

    public BoardLikeListResponseDto findByBoardLikeId(BoardLikeListRequestDto requestDto) {
        List<BoardLikeResponseDto> boardLikeResponseDto = boardLikeMapper.findByBoardLikeId(requestDto);
        BoardLikeListResponseDto boardLikeListResponseDto = new BoardLikeListResponseDto();
        boardLikeListResponseDto.setLikes(boardLikeResponseDto);

        return boardLikeListResponseDto;
    }

    public int toggleBoardLike(BoardToggleLikeRequestDto requestDto) {
        Integer article_id = requestDto.getArticle_id();

        if (article_id == null) {
            throw new NullPointerException(ErrorMessages.ARTICLE_NOT_FOUND);
        }
        BoardLikeListRequestDto boardLikeListRequestDto = new BoardLikeListRequestDto();
        boardLikeListRequestDto.setArticle_id(article_id);
        List<BoardLikeResponseDto> boardLikeResponseDto = boardLikeMapper.findByBoardLikeId(boardLikeListRequestDto);
        boolean isLiked = boardLikeResponseDto.stream()
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
