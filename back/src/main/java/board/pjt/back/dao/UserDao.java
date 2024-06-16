package board.pjt.back.dao;

import board.pjt.back.domain.UserDto;
import board.pjt.back.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDao {
    private final UserMapper userMapper;

    UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    UserDto select(String email) {
        return userMapper.select(email);
    }

    List<UserDto> selectAll() {
        return userMapper.selectAll();
    }

    int insert(UserDto userDto) {
        return userMapper.insert(userDto);
    }

    int deleteUser(String email) {
        return userMapper.deleteUser(email);
    }

    int updateUser(UserDto dto) {
        return userMapper.updateUser(dto);
    }

}
