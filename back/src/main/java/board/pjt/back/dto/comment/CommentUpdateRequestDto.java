package board.pjt.back.dto.comment;

public class CommentUpdateRequestDto {
    private Integer article_comments_id;
    private String content;

    public CommentUpdateRequestDto() {
    }

    public CommentUpdateRequestDto(Integer article_comments_id, String content) {
        this.article_comments_id = article_comments_id;
        this.content = content;
    }

    public Integer getArticle_comments_id() {
        return article_comments_id;
    }

    public String getContent() {
        return content;
    }
}
