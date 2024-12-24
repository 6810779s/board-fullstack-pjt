package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.constants.thumbnail.BasicThumbnail;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.ThumbnailDao;
import board.pjt.back.dto.thumbnail.*;
import board.pjt.back.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("/api/thumbnail")
public class ThumbnailController {
    @Value("${file.thumbnail-upload-dir}")
    private String thumbnailUploadDir;
    private final ThumbnailDao thumbnailDao;

    public ThumbnailController(ThumbnailDao thumbnailDao) {
        this.thumbnailDao = thumbnailDao;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<GetThumbnailResponseDto>> getThumbnail(@RequestParam long board_id){
        GetThumbnailResponseDto thumbnail = thumbnailDao.getThumbnail(board_id);
        ApiResponse<GetThumbnailResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, thumbnail);
        return ResponseEntity.ok(response);
    }

    // 나중에 해당 api를 지우고 해당 서비스만 board에서 사용할 것
    //사용자가 대표이미지 업데이트를 안했을 경우 기본 이미지 업데이트.
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createThumbnail(@AuthenticationPrincipal UserDetails userDetails, @RequestParam(value="file",required = false)MultipartFile file){
        FileUtil fileUtil = new FileUtil(thumbnailUploadDir);
        String fileName = BasicThumbnail.THUMBNAIL_FILE_NAME;
        String filePath = Paths.get(BasicThumbnail.THUMBNAIL_FILE_PATH).toString();
        String fileExtension = BasicThumbnail.THUMBNAIL_FILE_EXTENSION;
        if(file !=null && !file.isEmpty()){
            Map<String, String> fileDetails =  fileUtil.createFile(file);
            fileName = fileDetails.get("fileName");
            filePath = fileDetails.get("filePath");
            fileExtension = fileDetails.get("fileExtension");
        }
        CreateThumbnailRequestDto createThumbnailRequestDto = new CreateThumbnailRequestDto(1000,userDetails.getUsername(), fileName, filePath, fileExtension);
        thumbnailDao.createThumbnail(createThumbnailRequestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<Void>> updateThumbnail(@AuthenticationPrincipal UserDetails userDetails,@RequestParam("board_id") long board_id, @RequestParam(value="file", required = false)MultipartFile file){
        FileUtil fileUtil = new FileUtil(thumbnailUploadDir);
        String fileName = BasicThumbnail.THUMBNAIL_FILE_NAME;
        String filePath = Paths.get(BasicThumbnail.THUMBNAIL_FILE_PATH).toString();
        String fileExtension = BasicThumbnail.THUMBNAIL_FILE_EXTENSION;
        String email = userDetails.getUsername();
        String oldFilePath = thumbnailDao.getThumbnailPathByBoardId(board_id);
        if (oldFilePath != null && !oldFilePath.equals(BasicThumbnail.THUMBNAIL_FILE_PATH)){
            fileUtil.deleteExistingImage(oldFilePath);
        }
        if(file !=null && !file.isEmpty()){
            Map<String, String> fileDetails =  fileUtil.createFile(file);
            fileName = fileDetails.get("fileName");
            filePath = fileDetails.get("filePath");
            fileExtension = fileDetails.get("fileExtension");
        }
        UpdateThumbnailRequestDto requestDto = new UpdateThumbnailRequestDto(fileName, filePath, fileExtension, email, board_id);
        thumbnailDao.updateThumbnail(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.UPDATE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<Void>> deleteThumbnail(@RequestBody DeleteThumbnailRequestDto requestDto){
        thumbnailDao.deleteThumbnail(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
