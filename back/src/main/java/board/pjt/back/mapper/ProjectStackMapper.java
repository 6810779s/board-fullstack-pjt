package board.pjt.back.mapper;

import board.pjt.back.dto.projectStack.ProjectStackCreateListRequestDto;
import board.pjt.back.dto.projectStack.ProjectStackDeleteRequestDto;
import board.pjt.back.dto.projectStack.ProjectStackGetListRequestDto;
import board.pjt.back.dto.projectStack.ProjectStackGetListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectStackMapper {
    void createProjectStackList(ProjectStackCreateListRequestDto dto);

    List<ProjectStackGetListResponseDto> getProjectStackList(ProjectStackGetListRequestDto dto);

    void deleteProjectStack(ProjectStackDeleteRequestDto dto);
}
