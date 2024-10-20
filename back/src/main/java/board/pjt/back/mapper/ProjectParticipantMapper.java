package board.pjt.back.mapper;

import board.pjt.back.dto.projectParticipant.ProjectParticipantCreateRequestDto;
import board.pjt.back.dto.projectParticipant.ProjectParticipantDeleteByBoardIdDto;
import board.pjt.back.dto.projectParticipant.ProjectParticipantGetByBoardIdRequestDto;
import board.pjt.back.dto.projectParticipant.ProjectParticipantGetListByBoardIdResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectParticipantMapper {
    void insert(ProjectParticipantCreateRequestDto dto);

    List<ProjectParticipantGetListByBoardIdResponseDto> getProjectParticipantByBoardId(ProjectParticipantGetByBoardIdRequestDto dto);

    void deleteProjectParticipantByBoardId(ProjectParticipantDeleteByBoardIdDto dto);
}
