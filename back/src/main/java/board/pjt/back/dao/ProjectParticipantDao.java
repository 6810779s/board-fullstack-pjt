package board.pjt.back.dao;

import board.pjt.back.dto.projectParticipant.*;
import board.pjt.back.mapper.ProjectParticipantMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectParticipantDao {
    private final ProjectParticipantMapper projectParticipantMapper;

    public ProjectParticipantDao(ProjectParticipantMapper projectParticipantMapper) {
        this.projectParticipantMapper = projectParticipantMapper;
    }

    public List<ProjectParticipantGetMyProjectResponseDto> getProjectParticipantMyProject(String userEmail){
        return projectParticipantMapper.getProjectParticipantMyProject(userEmail);
    }

    @Transactional
    public void insert(ProjectParticipantCreateRequestDto requestDto){
        ProjectParticipantDeleteByBoardIdDto deleteByBoardIdDto = new ProjectParticipantDeleteByBoardIdDto();
        deleteByBoardIdDto.setBoard_id(requestDto.getBoard_id());
        projectParticipantMapper.deleteProjectParticipantByBoardId(deleteByBoardIdDto);
        projectParticipantMapper.insert(requestDto);
    }

    public List<ProjectParticipantGetListByBoardIdResponseDto> getProjectParticipantByBoardId(ProjectParticipantGetByBoardIdRequestDto requestDto){
        return projectParticipantMapper.getProjectParticipantByBoardId(requestDto);
    }


}
