package board.pjt.back.mapper;

import board.pjt.back.dto.thumbnail.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThumbnailMapper {
void createThumbnail(CreateThumbnailRequestDto dto);
GetThumbnailResponseDto getThumbnail(GetThumbnailRequestDto dto);
void updateThumbnail(UpdateThumbnailRequestDto dto);
void deleteThumbnail(DeleteThumbnailRequestDto dto);

}
