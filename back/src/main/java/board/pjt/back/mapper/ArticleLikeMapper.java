package board.pjt.back.mapper;

import board.pjt.back.domain.ArticleLikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleLikeMapper {
    List<ArticleLikeDto> selectAll();

    ArticleLikeDto select(int article_id);

    List<ArticleLikeDto> findByArticleLikeId(int article_like_id);

    int delete(int article_like_id);

    int insert(ArticleLikeDto dto);

}
