package board.pjt.back.dao;

import board.pjt.back.common.constants.thumbnail.BasicThumbnail;
import board.pjt.back.dto.thumbnail.*;
import board.pjt.back.mapper.ThumbnailMapper;
import board.pjt.back.utils.FileUtil;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.Map;

@Service
public class ThumbnailDao {
    @Value("${file.thumbnail-upload-dir}")
    private String thumbnailUploadDir;
    private final ThumbnailMapper thumbnailMapper;

    public ThumbnailDao(ThumbnailMapper thumbnailMapper) {
        this.thumbnailMapper = thumbnailMapper;
    }

    public void createThumbnail(MultipartFile file, long board_id, String email){
        System.out.println("create thumbnail");
        FileUtil fileUtil = new FileUtil(thumbnailUploadDir);
        String fileName = BasicThumbnail.THUMBNAIL_FILE_NAME;
        String filePath = Paths.get(BasicThumbnail.THUMBNAIL_FILE_PATH).toString();
        String fileExtension = BasicThumbnail.THUMBNAIL_FILE_EXTENSION;
        if(file !=null && !file.isEmpty()){
            Map<String, String> fileDetails =  fileUtil.createFile(file);
            fileName = fileDetails.get("fileName");
            fileExtension = fileDetails.get("fileExtension");
            filePath = "/uploads/thumbnail/"+fileName;
        }
        CreateThumbnailRequestDto createThumbnailRequestDto = new CreateThumbnailRequestDto(board_id, email, fileName, filePath, fileExtension);
        thumbnailMapper.createThumbnail(createThumbnailRequestDto);
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
