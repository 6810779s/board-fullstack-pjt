package board.pjt.back.mapper;

import board.pjt.back.dto.projectAttachment.ProjectAttachmentCreateListRequestDto;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentDeleteRequestDto;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentGetListRequestDto;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentGetListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectAttachmentMapper {
    void createProjectAttachmentList(ProjectAttachmentCreateListRequestDto dto);

    void deleteProjectAttachment(ProjectAttachmentDeleteRequestDto dto);

    List<ProjectAttachmentGetListResponseDto> getProjectAttachmentList(ProjectAttachmentGetListRequestDto dto);

}
