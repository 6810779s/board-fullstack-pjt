package board.pjt.back.dao;

import board.pjt.back.dto.projectAttachment.ProjectAttachmentCreateListRequestDto;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentDeleteRequestDto;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentGetListRequestDto;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentGetListResponseDto;
import board.pjt.back.mapper.ProjectAttachmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectAttachmentDao {

    private final ProjectAttachmentMapper projectAttachmentMapper;

    public ProjectAttachmentDao(ProjectAttachmentMapper projectAttachmentMapper) {
        this.projectAttachmentMapper = projectAttachmentMapper;
    }

    @Transactional
    public void createProjectAttachmentList(ProjectAttachmentCreateListRequestDto requestDto){
        ProjectAttachmentDeleteRequestDto deleteRequestDto = new ProjectAttachmentDeleteRequestDto();
        deleteRequestDto.setBoard_id(requestDto.getBoard_id());
        projectAttachmentMapper.deleteProjectAttachment(deleteRequestDto);
        projectAttachmentMapper.createProjectAttachmentList(requestDto);
    }

    public void deleteProjectAttachment(ProjectAttachmentDeleteRequestDto requestDto){
        projectAttachmentMapper.deleteProjectAttachment(requestDto);
    }

    public List<ProjectAttachmentGetListResponseDto> getProjectAttachmentList(ProjectAttachmentGetListRequestDto requestDto){
        return projectAttachmentMapper.getProjectAttachmentList(requestDto);
    }
}
