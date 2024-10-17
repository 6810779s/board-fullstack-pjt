package board.pjt.back.dao;

import board.pjt.back.dto.projectUrl.ProjectUrlCreateRequestDto;
import board.pjt.back.dto.projectUrl.ProjectUrlDeleteRequestDto;
import board.pjt.back.dto.projectUrl.ProjectUrlGetListRequestDto;
import board.pjt.back.dto.projectUrl.ProjectUrlGetListResponseDto;
import board.pjt.back.mapper.ProjectUrlMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectUrlDao {
    private final ProjectUrlMapper projectUrlMapper;

    public ProjectUrlDao(ProjectUrlMapper projectUrlMapper){
        this.projectUrlMapper = projectUrlMapper;
    }

    @Transactional
    public void createProjectUrl(ProjectUrlCreateRequestDto requestDto){
        ProjectUrlDeleteRequestDto deleteDto = new ProjectUrlDeleteRequestDto();
        deleteDto.setBoard_id(requestDto.getBoard_id());
        projectUrlMapper.deleteProjectUrl(deleteDto);
        projectUrlMapper.createProjectUrl(requestDto);
    }

    public List<ProjectUrlGetListResponseDto> getProjectUrlList(ProjectUrlGetListRequestDto requestDto){
        return projectUrlMapper.getProjectUrlList(requestDto);
    }

    public void deleteProjectUrl(ProjectUrlDeleteRequestDto requestDto){
        projectUrlMapper.deleteProjectUrl(requestDto);
    }

}
