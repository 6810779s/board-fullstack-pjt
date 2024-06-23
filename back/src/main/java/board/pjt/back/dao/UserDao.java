package board.pjt.back.dao;

import board.pjt.back.domain.UserDto;
import board.pjt.back.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements UserMapper {
    private final UserMapper userMapper;

    UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDto select(String email) {
        return userMapper.select(email);
    }

    @Override
    public List<UserDto> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int insert(UserDto userDto) {
        return userMapper.insert(userDto);
    }

    @Override
    public int deleteUser(String email) {
        return userMapper.deleteUser(email);
    }

    @Override
    public int updateUser(UserDto dto) {
        return userMapper.updateUser(dto);
    }

}
