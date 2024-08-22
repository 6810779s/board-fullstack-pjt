package board.pjt.back.mapper;

import board.pjt.back.dto.category.CategoryDeleteRequestDto;
import board.pjt.back.dto.category.CategorySelectRequestDto;
import board.pjt.back.dto.category.CategorySelectResponseDto;
import board.pjt.back.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<CategorySelectResponseDto> selectAll();

    CategorySelectResponseDto select(CategorySelectRequestDto requestDto);

    int insert(CategoryEntity requestDto);

    int delete(CategoryDeleteRequestDto requestDto);


    int update(CategoryEntity requestDto);
}
