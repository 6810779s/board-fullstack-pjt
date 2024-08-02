package board.pjt.back.domain.comment;

public class CommentDetailRequestDto {
    private Integer article_comments_id;

    public CommentDetailRequestDto() {

    }

    public CommentDetailRequestDto(Integer article_comments_id) {
        this.article_comments_id = article_comments_id;
    }

    public Integer getArticle_comments_id() {
        return article_comments_id;
    }

    public void setArticle_comments_id(Integer article_comments_id) {
        this.article_comments_id = article_comments_id;
    }
}
