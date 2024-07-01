package board.pjt.back.dao;

import board.pjt.back.domain.ArticleCommentsLikeDto;
import board.pjt.back.mapper.ArticleCommentsLikeMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleCommentsLikeDao implements ArticleCommentsLikeMapper {
    private final ArticleCommentsLikeMapper articleCommentsLikeMapper;

    public ArticleCommentsLikeDao(ArticleCommentsLikeMapper articleCommentsLikeMapper) {
        this.articleCommentsLikeMapper = articleCommentsLikeMapper;
    }

    @Override
    public List<ArticleCommentsLikeDto> selectAll() {
        return articleCommentsLikeMapper.selectAll();
    }

    @Override
    public List<ArticleCommentsLikeDto> findByCommentId(int comment_id) {
        return articleCommentsLikeMapper.findByCommentId(comment_id);
    }

    @Override
    public ArticleCommentsLikeDto select(int article_comments_like_id) {
        return articleCommentsLikeMapper.select(article_comments_like_id);
    }

    @Override
    public int delete(int article_comments_like_id) {
        return articleCommentsLikeMapper.delete(article_comments_like_id);
    }

    @Override
    public int insert(ArticleCommentsLikeDto dto) {
        return articleCommentsLikeMapper.insert(dto);
    }

}
