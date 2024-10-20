package board.pjt.back.dao;

import board.pjt.back.dto.feedback.*;
import board.pjt.back.mapper.FeedbackMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackDao {
    private final FeedbackMapper feedbackMapper;

    public FeedbackDao(FeedbackMapper feedbackMapper) {
        this.feedbackMapper = feedbackMapper;
    }

    public List<FeedbackGetListResponseDto> getFeedbackListByToUserEmail(FeedbackGetListRequestDto requestDto){
        return feedbackMapper.getFeedbackListByToUserEmail(requestDto);
    }

    public void createFeedback(FeedbackCreateRequestDto requestDto){
        feedbackMapper.createFeedback(requestDto);
    }

    public void deleteFeedbackById(FeedbackDeleteRequestDto requestDto){
        feedbackMapper.deleteFeedbackById(requestDto);
    }

    public void updateFeedbackByFeedbackId(FeedbackUpdateRequestDto requestDto){
        feedbackMapper.updateFeedbackByFeedbackId(requestDto);
    }
}
