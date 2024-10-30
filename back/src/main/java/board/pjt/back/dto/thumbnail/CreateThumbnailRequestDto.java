package board.pjt.back.dto.thumbnail;

import java.util.Objects;

public class CreateThumbnailRequestDto {
    private int board_id;
    private String file_name;
    private String file_path;
    private String file_extension;
    private String created_by;

    public CreateThumbnailRequestDto() {
    }

    public CreateThumbnailRequestDto(int board_id, String created_by,String file_name, String file_path, String file_extension) {
        this.board_id = board_id;
        this.created_by = created_by;
        this.file_name = file_name;
        this.file_path = file_path;
        this.file_extension = file_extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateThumbnailRequestDto that = (CreateThumbnailRequestDto) o;
        return board_id == that.board_id && Objects.equals(file_name, that.file_name) && Objects.equals(file_path, that.file_path) && Objects.equals(file_extension, that.file_extension) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, file_name, file_path, file_extension, created_by);
    }

    @Override
    public String toString() {
        return "CreateThumbnailRequestDto{" +
                "board_id=" + board_id +
                ", file_name='" + file_name + '\'' +
                ", file_path='" + file_path + '\'' +
                ", file_extension='" + file_extension + '\'' +
                ", created_by='" + created_by + '\'' +
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

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }
}
