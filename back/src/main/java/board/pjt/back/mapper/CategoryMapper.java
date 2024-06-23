package board.pjt.back.mapper;

import board.pjt.back.domain.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int insert(CategoryDto dto);

    int delete(int category_id);

    CategoryDto select(int category_id);

    List<CategoryDto> selectAll();

    int update(CategoryDto dto);
}
