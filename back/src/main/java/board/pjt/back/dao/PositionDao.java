package board.pjt.back.dao;

import board.pjt.back.dto.position.PositionCreateRequestDto;
import board.pjt.back.dto.position.PositionGetListRequestDto;
import board.pjt.back.dto.position.PositionGetListResponseDto;
import board.pjt.back.mapper.PositionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionDao {
    private final PositionMapper positionMapper;

    public PositionDao(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    public List<PositionGetListResponseDto> getPositionListByEmail(PositionGetListRequestDto requestDto){
        return positionMapper.getPositionListByEmail(requestDto);
    }

    @Transactional
    public void createPosition(PositionCreateRequestDto requestDto){
        positionMapper.deletePositionByEmail(requestDto.getCreated_by());
        positionMapper.createPosition(requestDto);
    }

    public void deletePositionByEmail(String email){
        positionMapper.deletePositionByEmail(email);
    }
}
