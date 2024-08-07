package board.pjt.back.domain.boardLike;

import java.util.List;

public class BoardLikeListResponseDto {
    private List<BoardLikeResponseDto> likes;
    private Integer totalLikes;

    public BoardLikeListResponseDto() {
    }

    public BoardLikeListResponseDto(List<BoardLikeResponseDto> likes, Integer totalLikes) {
        this.likes = likes;
        this.totalLikes = totalLikes;
    }

    public List<BoardLikeResponseDto> getLikes() {
        return likes;
    }

    public void setLikes(List<BoardLikeResponseDto> likes) {
        this.likes = likes;
        this.totalLikes = likes.size();
    }

    public Integer getTotalLikes() {
        return totalLikes;
    }
    
}
