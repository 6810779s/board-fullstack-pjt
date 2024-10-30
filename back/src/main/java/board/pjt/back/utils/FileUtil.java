package board.pjt.back.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {
    private final String uploadDir;

    public FileUtil(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    // 파일 확장자 추출
    public String getFileExtension(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        } else {
            return ""; // 확장자가 없는 경우
        }
    }

    // 파일 경로 생성
    public String createFileName(String fileName) {
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String fileExtension = getFileExtension(fileName);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return baseName + "_" + timestamp + "." + fileExtension;
    }

    // 파일 생성 및 정보 반환
    public Map<String, String> createFile(MultipartFile file) {
        try {
            String fileName = createFileName(file.getOriginalFilename());
            String fileExtension = getFileExtension(fileName);
            Path path = Paths.get(uploadDir + "/" + fileName);
            Files.write(path, file.getBytes());

            Map<String, String> fileDetails = new HashMap<>();
            fileDetails.put("fileName", fileName);
            fileDetails.put("filePath", path.toString());
            fileDetails.put("fileExtension", fileExtension);

            return fileDetails;
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 업로드 실패", e);
        }
    }

}
