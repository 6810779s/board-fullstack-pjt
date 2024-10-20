package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.ProjectParticipantDao;
import board.pjt.back.dto.projectParticipant.ProjectParticipantCreateRequestDto;
import board.pjt.back.dto.projectParticipant.ProjectParticipantGetByBoardIdRequestDto;
import board.pjt.back.dto.projectParticipant.ProjectParticipantGetListByBoardIdResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-participant")
public class ProjectParticipantController {
    private final ProjectParticipantDao projectParticipantDao;

    public ProjectParticipantController(ProjectParticipantDao projectParticipantDao) {
        this.projectParticipantDao = projectParticipantDao;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> insert(@RequestBody ProjectParticipantCreateRequestDto requestDto){
        projectParticipantDao.insert(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ProjectParticipantGetListByBoardIdResponseDto>>> getProjectParticipantByBoardId(@RequestBody ProjectParticipantGetByBoardIdRequestDto requestDto){
        List<ProjectParticipantGetListByBoardIdResponseDto> projectParticipantList = projectParticipantDao.getProjectParticipantByBoardId(requestDto);
        ApiResponse<List<ProjectParticipantGetListByBoardIdResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, projectParticipantList);
        return ResponseEntity.ok(response);

    }

//    @DeleteMapping("/")
}
