package board.pjt.back.dto.thumbnail;

import java.util.Objects;

public class GetThumbnailResponseDto {
    private int thumbnail_id;
    private String file_name;
    private String file_extension;

    public GetThumbnailResponseDto() {
    }

    public GetThumbnailResponseDto(int thumbnail_id, String file_name, String file_extension) {
        this.thumbnail_id = thumbnail_id;
        this.file_name = file_name;
        this.file_extension = file_extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetThumbnailResponseDto that = (GetThumbnailResponseDto) o;
        return thumbnail_id == that.thumbnail_id && Objects.equals(file_name, that.file_name) && Objects.equals(file_extension, that.file_extension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thumbnail_id, file_name, file_extension);
    }

    @Override
    public String toString() {
        return "GetThumbnailResponseDto{" +
                "thumbnail_id=" + thumbnail_id +
                ", file_name='" + file_name + '\'' +
                ", file_extension='" + file_extension + '\'' +
                '}';
    }

    public int getThumbnail_id() {
        return thumbnail_id;
    }

    public void setThumbnail_id(int thumbnail_id) {
        this.thumbnail_id = thumbnail_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_extension() {
        return file_extension;
    }

    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }
}
