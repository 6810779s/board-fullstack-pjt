package board.pjt.back.domain.commentLike;

public class CommentLikeResponseDto {
    Integer article_comments_like_id;
    String created_by;

    public CommentLikeResponseDto() {
    }

    public CommentLikeResponseDto(Integer article_comments_like_id, String created_by) {
        this.article_comments_like_id = article_comments_like_id;
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "CommentLikeResponseDto{" +
                "article_comments_like_id=" + article_comments_like_id +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public Integer getArticle_comments_like_id() {
        return article_comments_like_id;
    }

    public void setArticle_comments_like_id(Integer article_comments_like_id) {
        this.article_comments_like_id = article_comments_like_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
