package board.pjt.back.dao;

import board.pjt.back.domain.CategoryDto;
import board.pjt.back.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao implements CategoryMapper {
    private final CategoryMapper categoryMapper;

    CategoryDao(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public int insert(CategoryDto dto) {
        return categoryMapper.insert(dto);
    }

    @Override
    public int delete(int category_id) {
        return categoryMapper.delete(category_id);
    }

    @Override
    public CategoryDto select(int category_id) {
        return categoryMapper.select(category_id);
    }

    @Override
    public List<CategoryDto> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public int update(CategoryDto dto) {
        return categoryMapper.update(dto);
    }


}
