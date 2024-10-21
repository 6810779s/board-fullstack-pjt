package board.pjt.back.dao;

import board.pjt.back.dto.statusMessage.StatusMessageCreateRequestDto;
import board.pjt.back.dto.statusMessage.StatusMessageGetListResponseDto;
import board.pjt.back.mapper.StatusMessageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StatusMessageDao {
    private final StatusMessageMapper statusMessageMapper;

    public StatusMessageDao(StatusMessageMapper statusMessageMapper) {
        this.statusMessageMapper = statusMessageMapper;
    }

    @Transactional
    public void createStatusMessage(StatusMessageCreateRequestDto requestDto){
        statusMessageMapper.deleteStatusMessage(requestDto.getCreated_by());
        statusMessageMapper.createStatusMessage(requestDto);
    }

    public List<StatusMessageGetListResponseDto> getStatusMessage(String email){
        return statusMessageMapper.getStatusMessage(email);
    }

    public void deleteStatusMessage(String email){
        statusMessageMapper.deleteStatusMessage(email);
    }
}
