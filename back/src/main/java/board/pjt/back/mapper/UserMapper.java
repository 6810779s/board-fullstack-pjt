package board.pjt.back.mapper;

import board.pjt.back.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDto select(String email);

    List<UserDto> selectAll();

    int insert(UserDto dto);

    int deleteUser(String email);

    int updateUser(UserDto dto);

}
