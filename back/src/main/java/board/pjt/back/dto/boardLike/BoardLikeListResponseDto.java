package board.pjt.back.dto.boardLike;

import java.util.List;

public class BoardLikeListResponseDto {
    private List<BoardLikeResponseDto> likes;
    private int totalLikes;

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

    public int getTotalLikes() {
        return totalLikes;
    }

}
