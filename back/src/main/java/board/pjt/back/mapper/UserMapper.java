package board.pjt.back.mapper;

import board.pjt.back.dto.UserDto;
import board.pjt.back.dto.user.UserJoinRequestDto;
import board.pjt.back.dto.user.UserResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserResponseDto select(String email);

    List<UserDto> selectAll();

    void insert(UserJoinRequestDto requestDto);

    int deleteUser(String email);

    int updateUser(UserDto dto);

}
