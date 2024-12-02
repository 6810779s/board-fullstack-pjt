package board.pjt.back.dao;

import board.pjt.back.dto.thumbnail.*;
import board.pjt.back.mapper.ThumbnailMapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public class ThumbnailDao {
    private final ThumbnailMapper thumbnailMapper;

    public ThumbnailDao(ThumbnailMapper thumbnailMapper) {
        this.thumbnailMapper = thumbnailMapper;
    }

    public void createThumbnail(CreateThumbnailRequestDto requestDto){
        System.out.println("dao"+requestDto.toString());
        thumbnailMapper.createThumbnail(requestDto);
    }
    public GetThumbnailResponseDto getThumbnail(long board_id){
        System.out.println("board_id="+board_id);
        System.out.println("thumbnailMapper.getThumbnail(board_id)="+thumbnailMapper.getThumbnail(board_id));
        return thumbnailMapper.getThumbnail(board_id);
    }
    public void updateThumbnail(UpdateThumbnailRequestDto requestDto){
        thumbnailMapper.updateThumbnail(requestDto);
    }
    public void deleteThumbnail(DeleteThumbnailRequestDto requestDto){
        thumbnailMapper.deleteThumbnail(requestDto);
    }

    public String getThumbnailPathByBoardId(long board_id){
        return thumbnailMapper.getThumbnailPathByBoardId(board_id);
    }
}
