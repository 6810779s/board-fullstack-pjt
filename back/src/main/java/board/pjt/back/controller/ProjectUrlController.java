package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.ProjectUrlDao;
import board.pjt.back.dto.projectUrl.ProjectUrlCreateRequestDto;
import board.pjt.back.dto.projectUrl.ProjectUrlDeleteRequestDto;
import board.pjt.back.dto.projectUrl.ProjectUrlGetListRequestDto;
import board.pjt.back.dto.projectUrl.ProjectUrlGetListResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-url")
public class ProjectUrlController {
    private final ProjectUrlDao projectUrlDao;
    public ProjectUrlController(ProjectUrlDao projectUrlDao) {
        this.projectUrlDao = projectUrlDao;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createProjectUrl(@RequestBody ProjectUrlCreateRequestDto requestDro){
        projectUrlDao.createProjectUrl(requestDro);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ProjectUrlGetListResponseDto>>> getProjectUrlList(@RequestBody ProjectUrlGetListRequestDto requestDto){
        List<ProjectUrlGetListResponseDto> projectUrlList = projectUrlDao.getProjectUrlList(requestDto);
        ApiResponse<List<ProjectUrlGetListResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS,projectUrlList);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse<Void>> deleteProjectUrl(@RequestBody ProjectUrlDeleteRequestDto requestDto){
        projectUrlDao.deleteProjectUrl(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
