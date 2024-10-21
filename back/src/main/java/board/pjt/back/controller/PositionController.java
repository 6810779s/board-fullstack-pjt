package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.PositionDao;
import board.pjt.back.dto.position.PositionCreateRequestDto;
import board.pjt.back.dto.position.PositionGetListRequestDto;
import board.pjt.back.dto.position.PositionGetListResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    private final PositionDao positionDao;

    public PositionController(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<PositionGetListResponseDto>>> getPositionListByEmail(@AuthenticationPrincipal UserDetails userDetails, @RequestBody PositionGetListRequestDto requestDto){
        requestDto.setCreated_by(userDetails.getUsername());
        List<PositionGetListResponseDto> positionList = positionDao.getPositionListByEmail(requestDto);
        ApiResponse<List<PositionGetListResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, positionList);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createPosition(@AuthenticationPrincipal UserDetails userDetails, @RequestBody PositionCreateRequestDto requestDto){
        requestDto.setCreated_by(userDetails.getUsername());
        positionDao.createPosition(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
