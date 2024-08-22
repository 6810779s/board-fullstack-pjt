package board.pjt.back.dao;

import board.pjt.back.dto.category.*;
import board.pjt.back.entity.CategoryEntity;
import board.pjt.back.mapper.CategoryMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PreAuthorize("hasRole('ADMIN')")
public class CategoryDao {
    private final CategoryMapper categoryMapper;

    CategoryDao(CategoryMapper categoryMapper) {

        this.categoryMapper = categoryMapper;
    }

    public List<CategorySelectResponseDto> selectAll() {

        return categoryMapper.selectAll();
    }

    public CategorySelectResponseDto select(CategorySelectRequestDto requestDto) {

        return categoryMapper.select(requestDto);
    }

    public int insert(UserDetails userDetails, CategoryCreateRequestDto requestDto) {
        CategoryEntity category = new CategoryEntity();
        category.setName(requestDto.getName());
        category.setCreated_by(userDetails.getUsername());
        return categoryMapper.insert(category);
    }

    public int delete(CategoryDeleteRequestDto requestDto) {

        return categoryMapper.delete(requestDto);
    }


    public int update(UserDetails userDetails, CategoryUpdateRequestDto requestDto) {
        CategoryEntity category = new CategoryEntity();
        category.setCategory_id(requestDto.getCategory_id());
        category.setName(requestDto.getName());
        category.setUpdated_by(userDetails.getUsername());
        return categoryMapper.update(category);
    }


}
