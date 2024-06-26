package board.pjt.back.dao;

import board.pjt.back.domain.ArticleLikeDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArticleLikeDaoTest {
    @Autowired
    private ArticleLikeDao articleLikeDao;

    @Disabled
    @DisplayName("article like selectAll test")
    @Test
    void selectAll() {
        List<ArticleLikeDto> dto = articleLikeDao.selectAll();
        assertEquals(3, dto.size());
    }

    @Disabled
    @DisplayName("article like select test")
    @Test
    void select() {
        ArticleLikeDto dto = articleLikeDao.select(2);
        assertEquals(66, dto.getArticle_id());
    }

    @Disabled
    @DisplayName("article like findByArticleLikeId test")
    @Test
    void findByArticleLikeId() {
        assertEquals(2, articleLikeDao.findByArticleLikeId(67).size());
    }

    @Disabled
    @DisplayName("article like delete test")
    @Test
    void delete() {
        assertEquals(1, articleLikeDao.delete(1));
    }

    @Disabled
    @DisplayName("article like insert test")
    @Test
    void insert() {
        ArticleLikeDto dto = new ArticleLikeDto(67, "test@naver.com");
        assertEquals(1, articleLikeDao.insert(dto));
    }
}