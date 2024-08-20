package board.pjt.back.dao;

import board.pjt.back.dto.UserDto;
import board.pjt.back.dto.user.UserJoinRequestDto;
import board.pjt.back.dto.user.UserResponseDto;
import board.pjt.back.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDao {
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    UserDao(UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserResponseDto select(String email) {
        return userMapper.select(email);
    }

    public List<UserDto> selectAll() {
        return userMapper.selectAll();
    }

    public void insert(UserJoinRequestDto requestDto) {
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();
        if (select(email) != null) { //nickname 중복 체크 필요
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }
        UserJoinRequestDto data = new UserJoinRequestDto();
        data.setEmail(email);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setBirth(requestDto.getBirth());
        data.setName(requestDto.getName());
        data.setNickname(requestDto.getNickname());
        userMapper.insert(data);
    }

    public int deleteUser(String email) {
        return userMapper.deleteUser(email);
    }

    public int updateUser(UserDto dto) {
        return userMapper.updateUser(dto);
    }

}
