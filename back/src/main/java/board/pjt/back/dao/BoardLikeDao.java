package board.pjt.back.dao;

import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.boardLike.BoardLikeListRequestDto;
import board.pjt.back.dto.boardLike.BoardLikeListResponseDto;
import board.pjt.back.dto.boardLike.BoardLikeResponseDto;
import board.pjt.back.dto.boardLike.BoardToggleLikeRequestDto;
import board.pjt.back.dto.common.PaginationRequestDto;
import board.pjt.back.entity.UserEntity;
import board.pjt.back.mapper.BoardLikeMapper;
import org.springframework.security.core.userdetails.UserDetails;
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

    public PageHandler<BoardLikeResponseDto> myBoardLikePagination(UserDetails userDetails, PaginationRequestDto requestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDetails.getUsername());
        List<BoardLikeResponseDto> boardLikeListResponseDtoList = boardLikeMapper.selectMyBoardLikeList(userEntity);
        PageHandler<BoardLikeResponseDto> boardLikeResponseDtoPageHandler = new PageHandler<>(boardLikeListResponseDtoList.size(), requestDto.getPage(), requestDto.getPageSize());
        boardLikeResponseDtoPageHandler.setContents(boardLikeListResponseDtoList);
        return boardLikeResponseDtoPageHandler;

    }

    public int toggleBoardLike(UserDetails userDetails, BoardToggleLikeRequestDto requestDto) {
        int board_id = requestDto.getBoard_id();
        String email = userDetails.getUsername();
        requestDto.setCreated_by(email);
        BoardLikeListRequestDto boardLikeListRequestDto = new BoardLikeListRequestDto();
        boardLikeListRequestDto.setBoard_id(board_id);
        boardLikeListRequestDto.setCreated_by(email);
        List<BoardLikeResponseDto> boardLikeResponseDto = boardLikeMapper.findByBoardLikeId(boardLikeListRequestDto);
        boolean isLiked = boardLikeResponseDto.stream()
                .anyMatch(like -> like.getCreated_by().equals(email));
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



}
