package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.ProjectParticipantDao;
import board.pjt.back.dto.projectParticipant.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
        //[TODO] 중복 participant 추가 불가하도록 유효성 검사 로직 추가 필요
        projectParticipantDao.insert(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create/participant")
    public ResponseEntity<ApiResponse<Void>> insertBoardCreator(@RequestBody ProjectParticipantCreateBoardParticipantDto requestDto, @AuthenticationPrincipal UserDetails userDetails){
        //[TODO] 중복 participant 추가 불가하도록 유효성 검사 로직 추가 필요
        requestDto.setUserEmail(userDetails.getUsername());
        projectParticipantDao.insertBoardCreator(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/my-project")
    public ResponseEntity<ApiResponse<List<ProjectParticipantGetMyProjectResponseDto>>> getProjectParticipantMyProject(@RequestParam("userEmail") String userEmail){
        List<ProjectParticipantGetMyProjectResponseDto> myProjectList = projectParticipantDao.getProjectParticipantMyProject(userEmail);
        ApiResponse<List<ProjectParticipantGetMyProjectResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, myProjectList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ProjectParticipantGetListByBoardIdResponseDto>>> getProjectParticipantByBoardId(@ModelAttribute ProjectParticipantGetByBoardIdRequestDto requestDto){
        List<ProjectParticipantGetListByBoardIdResponseDto> projectParticipantList = projectParticipantDao.getProjectParticipantByBoardId(requestDto);
        ApiResponse<List<ProjectParticipantGetListByBoardIdResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, projectParticipantList);
        return ResponseEntity.ok(response);

    }

//    @DeleteMapping("/")
}
