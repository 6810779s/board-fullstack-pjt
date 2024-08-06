package board.pjt.back.domain.boardLike;

public class BoardToggleLikeRequestDto {
    Integer article_id;
    String created_by;

    public BoardToggleLikeRequestDto() {
    }

    public BoardToggleLikeRequestDto(Integer article_id, String created_by) {
        this.article_id = article_id;
        this.created_by = created_by;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
