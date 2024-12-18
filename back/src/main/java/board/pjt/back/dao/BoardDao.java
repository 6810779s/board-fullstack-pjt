package board.pjt.back.dao;

import board.pjt.back.common.constants.ErrorMessages;
import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.board.*;
import board.pjt.back.dto.common.PaginationRequestDto;
import board.pjt.back.dto.projectParticipant.ProjectParticipantCreateBoardParticipantDto;
import board.pjt.back.entity.UserEntity;
import board.pjt.back.mapper.BoardMapper;
import board.pjt.back.mapper.ProjectParticipantMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardDao {
    private final BoardMapper boardMapper;
    private final ProjectParticipantMapper projectParticipantMapper;

    public BoardDao(BoardMapper boardMapper, ProjectParticipantMapper projectParticipantMapper) {
        this.boardMapper = boardMapper;
        this.projectParticipantMapper = projectParticipantMapper;
    }

    public PageHandler<BoardMainResponseDto> boardPagination(PaginationRequestDto requestDto) {
        Map<String, Object> params = new HashMap<>();
        params.put("searchType", requestDto.getSearchType().name());
        params.put("keyword", requestDto.getKeyword());
        params.put("limit", null);
        List<BoardMainResponseDto> boardList = boardMapper.selectAll(params);
        PageHandler<BoardMainResponseDto> boardResponseDtoPageHandler = new PageHandler<>(boardList.size(), requestDto.getPage(), requestDto.getPageSize());
        boardResponseDtoPageHandler.setContents(boardList);
        return boardResponseDtoPageHandler;
    }

    public PageHandler<BoardMainResponseDto> myBoardPagination(UserDetails userDetails, PaginationRequestDto requestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDetails.getUsername());
        List<BoardMainResponseDto> myBoardList = boardMapper.selectMyBoardList(userEntity);
        PageHandler<BoardMainResponseDto> boardResponseDtoPageHandler = new PageHandler<>(myBoardList.size(), requestDto.getPage(), requestDto.getPageSize());
        boardResponseDtoPageHandler.setContents(myBoardList);
        return boardResponseDtoPageHandler;
    }

    public BoardDetailResponseDto select(long board_id) {
        BoardDetailResponseDto dto = boardMapper.select(board_id);
        System.out.println(board_id);
        if (dto == null) {
            throw new IllegalArgumentException(ErrorMessages.BOARD_NOT_FOUND);
        }
        dto.setNextBoard(boardMapper.getNextBoard(board_id));
        dto.setPrevBoard(boardMapper.getPrevBoard(board_id));
        return dto;
    }

    public List<BoardMainResponseDto> getBoardByCriteria(Map param){
        return boardMapper.getBoardByCriteria(param);
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    public List<BoardMainResponseDto> selectAll(Integer limit) {
        Map<String, Object> params = new HashMap<>();
        params.put("searchType", "ALL");
        params.put("keyword", "");
        params.put("limit", limit);
        return boardMapper.selectAll(params);
    }

    @Transactional
    public void insert(BoardCreateRequestDto requestDto, String userEmail) {
        // TODO: category id 여부 체크, project_name 빈 문자열일때 에러처리, 1 <= participant_limit <= 100
        boardMapper.insert(requestDto);

        ProjectParticipantCreateBoardParticipantDto participantDto = new ProjectParticipantCreateBoardParticipantDto();
        participantDto.setUserEmail(userEmail);
        participantDto.setBoard_id(requestDto.getBoard_id());
        projectParticipantMapper.insertBoardCreator(participantDto);

    }

    public void delete(BoardDeleteRequestDto requestDto) {
        BoardDetailResponseDto board = select(requestDto.getBoard_id());
        if (board == null) {
            throw new IllegalArgumentException(ErrorMessages.BOARD_NOT_FOUND);
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
            throw new IllegalArgumentException(ErrorMessages.BOARD_NOT_FOUND);
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
