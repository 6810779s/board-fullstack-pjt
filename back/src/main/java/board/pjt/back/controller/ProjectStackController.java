package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.ProjectStackDao;
import board.pjt.back.dto.projectStack.ProjectStackCreateListRequestDto;
import board.pjt.back.dto.projectStack.ProjectStackDeleteRequestDto;
import board.pjt.back.dto.projectStack.ProjectStackGetListRequestDto;
import board.pjt.back.dto.projectStack.ProjectStackGetListResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-stack")
public class ProjectStackController {
    private final ProjectStackDao projectStackDao;

    public ProjectStackController(ProjectStackDao projectStackDao) {
        this.projectStackDao = projectStackDao;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createProjectStackList(@RequestBody ProjectStackCreateListRequestDto requestDto){
        projectStackDao.createProjectStackList(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ProjectStackGetListResponseDto>>> getProjectStackList(@RequestBody ProjectStackGetListRequestDto requestDto){
        List<ProjectStackGetListResponseDto> projectStackList = projectStackDao.getProjectStackList(requestDto);
        ApiResponse<List<ProjectStackGetListResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS,projectStackList);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse<Void>> deleteProjectStack(@RequestBody ProjectStackDeleteRequestDto requestDto){
        projectStackDao.deleteProjectStack(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
