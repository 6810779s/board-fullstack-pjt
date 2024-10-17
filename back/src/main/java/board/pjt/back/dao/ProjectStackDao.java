package board.pjt.back.dao;

import board.pjt.back.dto.projectStack.ProjectStackCreateListRequestDto;
import board.pjt.back.dto.projectStack.ProjectStackDeleteRequestDto;
import board.pjt.back.dto.projectStack.ProjectStackGetListRequestDto;
import board.pjt.back.dto.projectStack.ProjectStackGetListResponseDto;
import board.pjt.back.mapper.ProjectStackMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectStackDao {
    private final ProjectStackMapper projectStackMapper;

    public ProjectStackDao(ProjectStackMapper projectStackMapper) {
        this.projectStackMapper = projectStackMapper;
    }

    @Transactional
    public void createProjectStackList(ProjectStackCreateListRequestDto requestDto){
        ProjectStackDeleteRequestDto deleteRequestDto = new ProjectStackDeleteRequestDto();
        deleteRequestDto.setBoard_id(requestDto.getBoard_id());
        projectStackMapper.deleteProjectStack(deleteRequestDto);
        projectStackMapper.createProjectStackList(requestDto);
    }

    public List<ProjectStackGetListResponseDto> getProjectStackList(ProjectStackGetListRequestDto requestDto){
        return projectStackMapper.getProjectStackList(requestDto);
    }



    public void deleteProjectStack(ProjectStackDeleteRequestDto requestDto){
        projectStackMapper.deleteProjectStack(requestDto);
    }

}
