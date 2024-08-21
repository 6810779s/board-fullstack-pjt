package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.UserDao;
import board.pjt.back.dto.user.UserJoinRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/join")
    public ResponseEntity<ApiResponse<Void>> createUser(@RequestBody UserJoinRequestDto requestDto) {
        userDao.insert(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
