package board.pjt.back.mapper;

import board.pjt.back.domain.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    BoardDto select(int article_id);

    List<BoardDto> selectAll();

    int update(BoardDto dto);

    int insert(BoardDto dto);

    void deleteAll();

    int delete(int article_id);
}
