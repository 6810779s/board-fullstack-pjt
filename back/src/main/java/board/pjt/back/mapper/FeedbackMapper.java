package board.pjt.back.mapper;

import board.pjt.back.dto.feedback.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedbackMapper {
    List<FeedbackGetListResponseDto> getFeedbackListByToUserEmail(FeedbackGetListRequestDto dto);
    void createFeedback(FeedbackCreateRequestDto dto);

    void deleteFeedbackById(FeedbackDeleteRequestDto dto);
    void updateFeedbackByFeedbackId(FeedbackUpdateRequestDto dto);
}
