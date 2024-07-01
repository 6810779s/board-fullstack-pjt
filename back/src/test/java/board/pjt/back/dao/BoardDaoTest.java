package board.pjt.back.dao;

import board.pjt.back.domain.BoardDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoardDaoTest {
    @Autowired
    private BoardDao boardDao;

    void resetDatabase() {
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto("title2", "content board", 7, "test@naver.com");
        assertEquals(1, boardDao.insert(boardDto));
    }

    @Disabled
    @DisplayName("delete all")
    @Test
    void deleteAll() throws Exception {
        boardDao.deleteAll();
        assertEquals(0, (int) boardDao.selectAll().size());
    }

    @Disabled
    @DisplayName("delete test")
    @Test
    void delete() throws Exception {
        resetDatabase();
        int article_id = boardDao.selectAll().get(0).getArticle_id();
        boardDao.delete(article_id);
        assertEquals(0, (int) boardDao.selectAll().size());
    }

    @DisplayName("insert test")
    @Test
    void insertTest() throws Exception {
        BoardDto boardDto = new BoardDto("title13", "content board", 7, "test@naver.com");
        assertEquals(1, boardDao.insert(boardDto));
//        int size = boardDao.selectAll().size();
//        assertEquals(1, size);

    }

    @Disabled
    @DisplayName("selectAll Test")
    @Test
    public void selectAllTest() throws Exception {
        resetDatabase();
        List<BoardDto> boardList = boardDao.selectAll();
        assertEquals(1, (int) boardList.size());
    }

    @Disabled
    @DisplayName("select Test")
    @Test
    public void selectTest() throws Exception {
        resetDatabase();
        int article_id = boardDao.selectAll().get(0).getArticle_id();
        BoardDto board = boardDao.select(article_id);
        assertEquals("title2", board.getTitle());
    }

    @Disabled
    @DisplayName("update Test")
    @Test
    void updateTest() throws Exception {
        resetDatabase();
        BoardDto boardDto = new BoardDto("title", "test content", 4, "test@naver.com");
        int article_id = boardDao.selectAll().get(0).getArticle_id();
        boardDto.setArticle_id(article_id);
        assertEquals(1, boardDao.update(boardDto));
        assertEquals("test content", boardDao.select(article_id).getContent());
    }

}
