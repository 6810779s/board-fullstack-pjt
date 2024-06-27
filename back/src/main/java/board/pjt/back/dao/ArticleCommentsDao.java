package board.pjt.back.dao;

import board.pjt.back.domain.ArticleCommentsDto;
import board.pjt.back.mapper.ArticleCommentsMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleCommentsDao implements ArticleCommentsMapper {
    private final ArticleCommentsMapper articleCommentsMapper;

    public ArticleCommentsDao(ArticleCommentsMapper articleCommentsMapper) {
        this.articleCommentsMapper = articleCommentsMapper;
    }

    @Override
    public List<ArticleCommentsDto> selectAll() {
        return articleCommentsMapper.selectAll();
    }

    @Override
    public ArticleCommentsDto select(int articleComments_id) {
        return articleCommentsMapper.select(articleComments_id);
    }

    @Override
    public int insert(ArticleCommentsDto dto) {
        return articleCommentsMapper.insert(dto);
    }

    @Override
    public int update(ArticleCommentsDto dto) {
        return articleCommentsMapper.update(dto);
    }

    @Override
    public int delete(int articleComments_id) {
        return articleCommentsMapper.delete(articleComments_id);
    }
}
