package board.pjt.back.dto.comment;

public class CommentDeleteRequestDto {
    private Integer article_comments_id;

    public CommentDeleteRequestDto() {
    }

    public CommentDeleteRequestDto(Integer article_comments_id) {
        this.article_comments_id = article_comments_id;
    }

    public Integer getArticle_comments_id() {
        return article_comments_id;
    }
}
