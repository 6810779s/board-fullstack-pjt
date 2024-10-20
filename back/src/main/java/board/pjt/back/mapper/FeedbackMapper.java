package board.pjt.back.mapper;

import board.pjt.back.dto.feedback.FeedbackCreateRequestDto;
import board.pjt.back.dto.feedback.FeedbackDeleteRequestDto;
import board.pjt.back.dto.feedback.FeedbackGetListRequestDto;
import board.pjt.back.dto.feedback.FeedbackGetListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedbackMapper {
    List<FeedbackGetListResponseDto> getFeedbackListByToUserEmail(FeedbackGetListRequestDto dto);
    void createFeedback(FeedbackCreateRequestDto dto);

    void deleteFeedbackById(FeedbackDeleteRequestDto dto);
}
