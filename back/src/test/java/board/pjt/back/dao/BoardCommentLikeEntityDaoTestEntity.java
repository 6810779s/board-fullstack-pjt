package board.pjt.back.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardCommentLikeEntityDaoTestEntity {
    @Autowired
    private CommentLikeDao commentLikeDao;
    @Autowired
    private CommentDao commentDao;

    @Disabled
    @DisplayName("select all test")
    @Test
    void selectAll() {
//        int size = articleCommentsLikeDao.selectAll().size();
//        assertEquals(1, size);
    }

    @Disabled
    @DisplayName("select test")
    @Test
    void select() {
//        int article_comments_like_id = articleCommentsLikeDao.selectAll().get(0).getArticle_comments_like_id();
//        ArticleCommentsLikeDto dto = articleCommentsLikeDao.select(article_comments_like_id);
//        assertEquals("test@naver.com", dto.getCreated_by());
    }

    @Disabled
    @DisplayName("delete test")
    @Test
    void delete() {
//        int article_comments_like_id = articleCommentsLikeDao.selectAll().get(0).getArticle_comments_like_id();
//        assertEquals(1, articleCommentsLikeDao.delete(article_comments_like_id));
//        int size = articleCommentsLikeDao.selectAll().size();
//        assertEquals(0, size);
    }

    @Disabled
    @DisplayName("insert test")
    @Test
    void insert() {
//        int comment_id = articleCommentsDao.selectAll().get(1).getComments_id();
//        ArticleCommentsLikeDto dto = new ArticleCommentsLikeDto(comment_id, "test@naver.com");
//        assertEquals(1, articleCommentsLikeDao.insert(dto));
    }

    @Disabled
    @DisplayName("findByCommentId test")
    @Test
    void findByCommentId() {
//        List<ArticleCommentsLikeDto> dto = articleCommentsLikeDao.findByCommentId(2);
//        assertEquals(2, dto.size());
    }
}