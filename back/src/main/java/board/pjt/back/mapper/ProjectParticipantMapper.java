package board.pjt.back.mapper;

import board.pjt.back.dto.projectParticipant.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectParticipantMapper {
    void insert(ProjectParticipantCreateRequestDto dto);

    List<ProjectParticipantGetListByBoardIdResponseDto> getProjectParticipantByBoardId(ProjectParticipantGetByBoardIdRequestDto dto);

    List<ProjectParticipantGetMyProjectResponseDto> getProjectParticipantMyProject(String useEmail);
    void deleteProjectParticipantByBoardId(ProjectParticipantDeleteByBoardIdDto dto);
}
