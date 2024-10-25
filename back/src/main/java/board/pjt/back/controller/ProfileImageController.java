package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.constants.userProfile.BasicUserProfile;
import board.pjt.back.dao.ProfileImageDao;
import board.pjt.back.dto.profileImage.ProfileImageCreateRequestDto;
import board.pjt.back.dto.profileImage.ProfileImageGetResponseDto;
import board.pjt.back.dto.profileImage.ProfileImageUpdateRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/profile-image")
public class ProfileImageController {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final ProfileImageDao profileImageDao;

    public ProfileImageController(ProfileImageDao profileImageDao) {
        this.profileImageDao = profileImageDao;
    }

    public String getFileExtension(String fileName) {

        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        } else {
            return ""; // 확장자가 없는 경우
        }
    }

    public String getFilePath(String fileName) {
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String fileExtension = getFileExtension(fileName);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String newFileName = baseName + "_" + timestamp + "." + fileExtension;
        return newFileName;
    }

    public Map<String, String> createFile(MultipartFile file) {
        try {
            String fileName = getFilePath(file.getOriginalFilename());
            String fileExtension = getFileExtension(fileName);
            Path path = Paths.get(uploadDir + "/" + fileName);
            Files.write(path, file.getBytes());

            Map<String, String> fileDetails = new HashMap<>();
            fileDetails.put("fileName", fileName);
            fileDetails.put("path", path.toString());
            fileDetails.put("fileExtension", fileExtension);

            return fileDetails;
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 업로드 실패");
        }
    }

    private void deleteExistingImage(String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete the old profile image.");
        }
    }

    //처음 사용자 회원가입 시 만들어질 필드
    @PostMapping("/upload/basic-profile")
    public ResponseEntity<ApiResponse<Void>> uploadProfileImage(@AuthenticationPrincipal UserDetails userDetails) {
        String fileName = BasicUserProfile.PROFILE_IMAGE_FILE_NAME;
        Path path = Paths.get(BasicUserProfile.PROFILE_IMAGE_FILE_PATH);
        String fileExtension = BasicUserProfile.PROFILE_IMAGE_FILE_EXTENSION;
        ProfileImageCreateRequestDto profileImageCreateRequestDto = new ProfileImageCreateRequestDto(userDetails.getUsername(), fileName, path.toString(), fileExtension);

        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        profileImageDao.createProfileImage(profileImageCreateRequestDto);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/")
    public ResponseEntity<ApiResponse<ProfileImageGetResponseDto>> getProfileImage(@AuthenticationPrincipal UserDetails userDetails) {
        ProfileImageGetResponseDto profileImage = profileImageDao.getProfileImage(userDetails.getUsername());
        ApiResponse<ProfileImageGetResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, profileImage);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse<Void>> deleteProfileImage(@AuthenticationPrincipal UserDetails userDetails) {
        profileImageDao.deleteProfileImage(userDetails.getUsername());
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    //사용자가 자신이 변경한 프로필에서 다른 프로필로 변경할 경우 api
    @PutMapping("/update")
    public ResponseEntity<ApiResponse<Void>> updateProfileImage(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("file") MultipartFile file) {
        String email = userDetails.getUsername();
        String oldFilePath = profileImageDao.getProfileImagePathByEmail(email);
        if (oldFilePath != null && !oldFilePath.equals(BasicUserProfile.PROFILE_IMAGE_FILE_PATH)) {
            deleteExistingImage(oldFilePath);
        }

        Map<String, String> fileDetails = createFile(file);
        String fileName = fileDetails.get("fileName");
        Path path = Paths.get(fileDetails.get("path"));
        String fileExtension = fileDetails.get("fileExtension");

        ProfileImageUpdateRequestDto requestDto = new ProfileImageUpdateRequestDto(fileName, fileExtension, path.toString(), email);
        profileImageDao.updateProfileImage(requestDto);

        ApiResponse<Void> response = ApiResponse.of(SuccessCode.UPDATE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    //사용자가 자신이 변경한 프로필을 삭제했을 경우
    @PutMapping("/update/basic-profile")
    public ResponseEntity<ApiResponse<Void>> updateBasicProfileImage(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        String oldFilePath = profileImageDao.getProfileImagePathByEmail(email);
        if (oldFilePath != null) {
            deleteExistingImage(oldFilePath);
        }

        String fileName = BasicUserProfile.PROFILE_IMAGE_FILE_NAME;
        Path path = Paths.get(BasicUserProfile.PROFILE_IMAGE_FILE_PATH);
        String fileExtension = BasicUserProfile.PROFILE_IMAGE_FILE_EXTENSION;

        ProfileImageUpdateRequestDto requestDto = new ProfileImageUpdateRequestDto(fileName, fileExtension, path.toString(), email);
        profileImageDao.updateProfileImage(requestDto);

        ApiResponse<Void> response = ApiResponse.of(SuccessCode.UPDATE_SUCCESS);
        return ResponseEntity.ok(response);
    }

}
