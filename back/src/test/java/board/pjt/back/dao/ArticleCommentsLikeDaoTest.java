package board.pjt.back.dao;

import board.pjt.back.domain.ArticleCommentsLikeDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArticleCommentsLikeDaoTest {
    @Autowired
    private ArticleCommentsLikeDao articleCommentsLikeDao;
    @Autowired
    private ArticleCommentsDao articleCommentsDao;

    @Disabled
    @DisplayName("select all test")
    @Test
    void selectAll() {
        int size = articleCommentsLikeDao.selectAll().size();
        assertEquals(1, size);
    }

    @Disabled
    @DisplayName("select test")
    @Test
    void select() {
        int article_comments_like_id = articleCommentsLikeDao.selectAll().get(0).getArticle_comments_like_id();
        ArticleCommentsLikeDto dto = articleCommentsLikeDao.select(article_comments_like_id);
        assertEquals("test@naver.com", dto.getCreated_by());
    }

    @Disabled
    @DisplayName("delete test")
    @Test
    void delete() {
        int article_comments_like_id = articleCommentsLikeDao.selectAll().get(0).getArticle_comments_like_id();
        assertEquals(1, articleCommentsLikeDao.delete(article_comments_like_id));
        int size = articleCommentsLikeDao.selectAll().size();
        assertEquals(0, size);
    }

    @Disabled
    @DisplayName("insert test")
    @Test
    void insert() {
        int comment_id = articleCommentsDao.selectAll().get(0).getComments_id();
        ArticleCommentsLikeDto dto = new ArticleCommentsLikeDto(comment_id, "test@naver.com");
        assertEquals(1, articleCommentsLikeDao.insert(dto));

    }
}