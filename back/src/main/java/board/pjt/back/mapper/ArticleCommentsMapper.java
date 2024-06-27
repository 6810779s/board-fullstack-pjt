package board.pjt.back.mapper;

import board.pjt.back.domain.ArticleCommentsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleCommentsMapper {
    List<ArticleCommentsDto> selectAll();

    ArticleCommentsDto select(int articleComments_id);

    int insert(ArticleCommentsDto dto);

    int update(ArticleCommentsDto dto);

    int delete(int articleComments_id);
}
