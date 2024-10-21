package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.StatusMessageDao;
import board.pjt.back.dao.UserDao;
import board.pjt.back.dto.statusMessage.StatusMessageCreateRequestDto;
import board.pjt.back.dto.statusMessage.StatusMessageGetListResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status-message")
public class StatusMessageController {
    private final StatusMessageDao statusMessageDao;

    public StatusMessageController(StatusMessageDao statusMessageDao) {
        this.statusMessageDao = statusMessageDao;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createStatusMessage(@AuthenticationPrincipal UserDetails userDetails, @RequestBody StatusMessageCreateRequestDto requestDto){
        requestDto.setCreated_by(userDetails.getUsername());
        statusMessageDao.createStatusMessage(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<StatusMessageGetListResponseDto>>> getStatusMessage(@AuthenticationPrincipal UserDetails userDetails){
        List<StatusMessageGetListResponseDto> statusMessageList = statusMessageDao.getStatusMessage(userDetails.getUsername());
        ApiResponse<List<StatusMessageGetListResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, statusMessageList);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse<Void>> deleteStatusMessage(@AuthenticationPrincipal UserDetails userDetails){
        statusMessageDao.deleteStatusMessage(userDetails.getUsername());
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
