package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.ProjectAttachmentDao;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentCreateListRequestDto;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentDeleteRequestDto;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentGetListRequestDto;
import board.pjt.back.dto.projectAttachment.ProjectAttachmentGetListResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-attachment")
public class ProjectAttachmentController {
    private final ProjectAttachmentDao projectAttachmentDao;

    public ProjectAttachmentController(ProjectAttachmentDao projectAttachmentDao) {
        this.projectAttachmentDao = projectAttachmentDao;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createProjectAttachment(@RequestBody ProjectAttachmentCreateListRequestDto requestDto){
        projectAttachmentDao.createProjectAttachmentList(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse<Void>> deleteProjectAttachment(@RequestBody ProjectAttachmentDeleteRequestDto requestDto){
        projectAttachmentDao.deleteProjectAttachment(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ProjectAttachmentGetListResponseDto>>> getProjectAttachment(@RequestBody ProjectAttachmentGetListRequestDto requestDto){
        List<ProjectAttachmentGetListResponseDto> projectAttachmentList =projectAttachmentDao.getProjectAttachmentList(requestDto);
        ApiResponse<List<ProjectAttachmentGetListResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, projectAttachmentList);
        return ResponseEntity.ok(response);
    }

}
