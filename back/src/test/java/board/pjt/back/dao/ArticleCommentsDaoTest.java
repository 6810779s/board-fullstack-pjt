package board.pjt.back.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleCommentsDaoTest {
    @Autowired
    private CommentDao commentDao;

    @Disabled
    @DisplayName("selectAll Test")
    @Test
    void selectAll() {
        commentDao.selectAll();
    }

    @Disabled
    @DisplayName("select Test")
    @Test
    void select() {
//        List<ArticleCommentsDto> dtoList = articleCommentsDao.selectAll();
//        int comment_id = dtoList.get(0).getComments_id();
//        ArticleCommentsDto dto = articleCommentsDao.select(comment_id);
//        assertEquals(dto.getContent(), "test2 content");
    }

    @Disabled
    @DisplayName("insert Test")
    @Test
    void insert() {
//        ArticleCommentsDto dto = new ArticleCommentsDto(65, "test content", "test@naver.com", null);
//
//        assertEquals(1, articleCommentsDao.insert(dto));
    }

    @Disabled
    @DisplayName("update Test")
    @Test
    void update() {
//        ArticleCommentsDto dto = articleCommentsDao.select(1);
//        dto.setContent("test2 content");
//        dto.setUpdated_by("test@naver.com");
//        assertEquals(1, articleCommentsDao.update(dto));
    }

    @Disabled
    @DisplayName("delete test")
    @Test
    void delete() {
//        int comment_id = articleCommentsDao.selectAll().get(0).getComments_id();
//
//        assertEquals(1, articleCommentsDao.delete(comment_id));
//        int size = articleCommentsDao.selectAll().size();
//        assertEquals(0, size);
    }
}