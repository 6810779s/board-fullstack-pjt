package board.pjt.back.dao;

import board.pjt.back.domain.CategoryDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CategoryDaoTest {
    @Autowired
    private CategoryDao categoryDao;

    @Disabled
    @DisplayName("category insert test")
    @Test
    void insert() {
        CategoryDto dto = new CategoryDto("category6");
        System.out.println("dto: " + dto);
        assertEquals(1, categoryDao.insert(dto));
    }

    @Disabled
    @DisplayName("category delete test")
    @Test
    void delete() {
        int category_id = categoryDao.selectAll().get(0).getCategory_id();
        assertEquals(1, categoryDao.delete(category_id));
    }

    @Disabled
    @DisplayName("category select test")
    @Test
    void select() {
        String category_name = categoryDao.selectAll().get(0).getName();
        System.out.println("category_name" + category_name);
        assertEquals("category1", category_name);
    }

    @Disabled
    @DisplayName("category update test")
    @Test
    void update() {
        CategoryDto dto = categoryDao.selectAll().get(0);
        dto.setName("category2");
        categoryDao.update(dto);

        String category_name = categoryDao.selectAll().get(0).getName();
        assertEquals("category2", category_name);
    }


}