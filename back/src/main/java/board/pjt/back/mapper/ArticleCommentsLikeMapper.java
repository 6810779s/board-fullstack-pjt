package board.pjt.back.mapper;

import board.pjt.back.domain.ArticleCommentsLikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleCommentsLikeMapper {
    List<ArticleCommentsLikeDto> selectAll();

    ArticleCommentsLikeDto select(int article_comments_like_id);

    int delete(int article_comments_like_id);

    int insert(ArticleCommentsLikeDto dto);
}
