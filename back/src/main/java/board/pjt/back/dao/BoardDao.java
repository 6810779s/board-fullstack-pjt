package board.pjt.back.dao;

import board.pjt.back.common.constants.ErrorMessages;
import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.board.*;
import board.pjt.back.dto.common.PaginationRequestDto;
import board.pjt.back.entity.UserEntity;
import board.pjt.back.mapper.BoardMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardDao {
    private final BoardMapper boardMapper;

    public BoardDao(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public PageHandler<BoardResponseDto> boardPagination(PaginationRequestDto requestDto) {
        List<BoardResponseDto> boardList = boardMapper.selectAll();
        PageHandler<BoardResponseDto> boardResponseDtoPageHandler = new PageHandler<>(boardList.size(), requestDto.getPage(), requestDto.getPageSize());
        boardResponseDtoPageHandler.setContents(boardList);
        return boardResponseDtoPageHandler;
    }

    public PageHandler<BoardResponseDto> myBoardPagination(UserDetails userDetails, PaginationRequestDto requestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDetails.getUsername());
        List<BoardResponseDto> myBoardList = boardMapper.selectMyBoardList(userEntity);
        PageHandler<BoardResponseDto> boardResponseDtoPageHandler = new PageHandler<>(myBoardList.size(), requestDto.getPage(), requestDto.getPageSize());
        boardResponseDtoPageHandler.setContents(myBoardList);
        return boardResponseDtoPageHandler;
    }

    public BoardDetailResponseDto select(int board_id) {

        BoardDetailResponseDto dto = boardMapper.select(board_id);
        dto.setNextBoard(boardMapper.getNextBoard(board_id));
        dto.setPrevBoard(boardMapper.getPrevBoard(board_id));
        if (dto == null) {
            throw new IllegalArgumentException(ErrorMessages.ARTICLE_NOT_FOUND);
        }
        return dto;
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    public List<BoardResponseDto> selectAll() {
        return boardMapper.selectAll();
    }

    public void insert(BoardCreateRequestDto requestDto) {
        // TODO: category id 여부 체크
        boardMapper.insert(requestDto);
    }

    public void delete(BoardDeleteRequestDto requestDto) {
        BoardDetailResponseDto board = select(requestDto.getBoard_id());
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
        BoardDetailResponseDto board = select(requestDto.getBoard_id());
        if (board == null) {
            throw new IllegalArgumentException(ErrorMessages.ARTICLE_NOT_FOUND);
        }
        // [TODO] category_id에서 category가 category 목록에 포함 되어있는지 확인하는 로직 구현 필요
        boardMapper.update(requestDto);
        BoardDetailResponseDto updateBoard = select(requestDto.getBoard_id());

        if (updateBoard == null ||
                !updateBoard.getTitle().equals(requestDto.getTitle()) ||
                !updateBoard.getContent().equals(requestDto.getContent())) {
            throw new RuntimeException(requestDto.getBoard_id() + "번의 게시글이 업데이트되지 않았습니다.");
        }

    }


}
