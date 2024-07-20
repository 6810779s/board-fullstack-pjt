package board.pjt.back.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class pageHandlerTest {
    @Autowired
    private BoardDao boardDao;

    @Test
    @DisplayName("페이지네이션 테스트")
    void pageTest() {
//        List<BoardDto> boardList = boardDao.selectAll();
//        PageHandler<BoardDto> ph = new PageHandler<>(boardList.size(), 2, 5);
//        ph.setContents(boardList);
//
//        List<BoardDto> contents = ph.getContents();
//        assertEquals(1, ph.getNumberOfElements());
//        assertEquals(11, ph.getTotalItems());
//        assertEquals(3, ph.getTotalPages());

    }
}
