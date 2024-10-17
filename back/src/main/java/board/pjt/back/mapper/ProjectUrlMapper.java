package board.pjt.back.mapper;

import board.pjt.back.dto.projectUrl.ProjectUrlCreateRequestDto;
import board.pjt.back.dto.projectUrl.ProjectUrlDeleteRequestDto;
import board.pjt.back.dto.projectUrl.ProjectUrlGetListRequestDto;
import board.pjt.back.dto.projectUrl.ProjectUrlGetListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectUrlMapper {
    void createProjectUrl(ProjectUrlCreateRequestDto dto);

    List<ProjectUrlGetListResponseDto> getProjectUrlList(ProjectUrlGetListRequestDto dto);

    void deleteProjectUrl(ProjectUrlDeleteRequestDto dto);
}
