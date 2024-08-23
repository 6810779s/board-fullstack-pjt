package board.pjt.back.dao;

import board.pjt.back.common.constants.ErrorMessages;
import board.pjt.back.dto.PageHandler;
import board.pjt.back.dto.commentLike.CommentLikeListRequestDto;
import board.pjt.back.dto.commentLike.CommentLikeListResponseDto;
import board.pjt.back.dto.commentLike.CommentLikeResponseDto;
import board.pjt.back.dto.commentLike.CommentLikeToggleRequestDto;
import board.pjt.back.dto.common.PaginationRequestDto;
import board.pjt.back.entity.UserEntity;
import board.pjt.back.mapper.CommentLikeMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentLikeDao {
    private final CommentLikeMapper commentLikeMapper;

    public CommentLikeDao(CommentLikeMapper commentLikeMapper) {
        this.commentLikeMapper = commentLikeMapper;
    }

    public PageHandler<CommentLikeResponseDto> myCommentLikePagination(UserDetails userDetails, PaginationRequestDto requestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDetails.getUsername());
        List<CommentLikeResponseDto> commentLikeResponseDtoList = commentLikeMapper.myCommentLikeList(userEntity);
        PageHandler<CommentLikeResponseDto> commentLikeResponseDtoPageHandler = new PageHandler<>(commentLikeResponseDtoList.size(), requestDto.getPage(), requestDto.getPageSize());
        commentLikeResponseDtoPageHandler.setContents(commentLikeResponseDtoList);
        return commentLikeResponseDtoPageHandler;
    }

    public CommentLikeListResponseDto findByCommentId(CommentLikeListRequestDto commentLikeListRequestDto) {
        if (commentLikeListRequestDto.getComment_id() == null) {
            throw new NullPointerException(ErrorMessages.COMMENT_NOT_FOUND);
        }
        List<CommentLikeResponseDto> commentLikeResponseDto = commentLikeMapper.findByCommentId(commentLikeListRequestDto);
        CommentLikeListResponseDto commentLikeListResponseDto = new CommentLikeListResponseDto();
        commentLikeListResponseDto.setCommentLikeResponseDto(commentLikeResponseDto);

        return commentLikeListResponseDto;
    }

    public int toggleCommentLike(CommentLikeToggleRequestDto requestDto) {
        if (requestDto.getComment_id() == null) {
            throw new NullPointerException(ErrorMessages.COMMENT_NOT_FOUND);
        }
        CommentLikeListRequestDto commentLikeListRequestDto = new CommentLikeListRequestDto();
        commentLikeListRequestDto.setComment_id(requestDto.getComment_id());
        List<CommentLikeResponseDto> commentLikeResponseDto = commentLikeMapper.findByCommentId(commentLikeListRequestDto);
        boolean isLiked = commentLikeResponseDto.stream().anyMatch(like -> like.getCreated_by().equals(requestDto.getCreated_by()));
        if (isLiked) {
            commentLikeMapper.delete(requestDto);
            return 0;
        } else {
            commentLikeMapper.insert(requestDto);
            return 1;
        }
    }


}
