package board.pjt.back.mapper;

import board.pjt.back.dto.statusMessage.StatusMessageCreateRequestDto;
import board.pjt.back.dto.statusMessage.StatusMessageGetListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatusMessageMapper {
    void createStatusMessage(StatusMessageCreateRequestDto dto);
    List<StatusMessageGetListResponseDto> getStatusMessage(String email);
    void deleteStatusMessage(String email);

}
