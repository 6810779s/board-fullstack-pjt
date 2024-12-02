package board.pjt.back.dto.thumbnail;

import java.util.Objects;

public class UpdateThumbnailRequestDto {
    private String file_name;
    private String file_path;
    private String file_extension;
    private String updated_by;
    private long board_id;

    public UpdateThumbnailRequestDto() {
    }

    public UpdateThumbnailRequestDto(String file_name, String file_path, String file_extension, String updated_by, long board_id) {
        this.file_name = file_name;
        this.file_path = file_path;
        this.file_extension = file_extension;
        this.updated_by = updated_by;
        this.board_id = board_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateThumbnailRequestDto that = (UpdateThumbnailRequestDto) o;
        return board_id == that.board_id && Objects.equals(file_name, that.file_name) && Objects.equals(file_path, that.file_path) && Objects.equals(file_extension, that.file_extension) && Objects.equals(updated_by, that.updated_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file_name, file_path, file_extension, updated_by, board_id);
    }

    @Override
    public String toString() {
        return "UpdateThumbnailRequestDto{" +
                "file_name='" + file_name + '\'' +
                ", file_path='" + file_path + '\'' +
                ", file_extension='" + file_extension + '\'' +
                ", updated_by='" + updated_by + '\'' +
                ", board_id=" + board_id +
                '}';
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_extension() {
        return file_extension;
    }

    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }
}
