package board.pjt.back.mapper;

import board.pjt.back.dto.position.PositionCreateRequestDto;
import board.pjt.back.dto.position.PositionGetListRequestDto;
import board.pjt.back.dto.position.PositionGetListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionMapper {
    List<PositionGetListResponseDto> getPositionListByEmail(PositionGetListRequestDto dto);
    void createPosition(PositionCreateRequestDto dto);
    void deletePositionByEmail(String email);
}
