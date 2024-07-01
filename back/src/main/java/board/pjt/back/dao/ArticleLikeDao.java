package board.pjt.back.dao;

import board.pjt.back.domain.ArticleLikeDto;
import board.pjt.back.mapper.ArticleLikeMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleLikeDao implements ArticleLikeMapper {
    private final ArticleLikeMapper articleLikeMapper;

    public ArticleLikeDao(ArticleLikeMapper articleLikeMapper) {
        this.articleLikeMapper = articleLikeMapper;
    }

    public List<ArticleLikeDto> selectAll() {
        return articleLikeMapper.selectAll();
    }

    public ArticleLikeDto select(int article_like_id) {
        return articleLikeMapper.select(article_like_id);
    }

    public List<ArticleLikeDto> findByArticleLikeId(int article_id) {
        return articleLikeMapper.findByArticleLikeId(article_id);
    }

    public int delete(int article_like_id) {
        return articleLikeMapper.delete(article_like_id);
    }

    public int insert(ArticleLikeDto dto) {
        return articleLikeMapper.insert(dto);
    }


}
