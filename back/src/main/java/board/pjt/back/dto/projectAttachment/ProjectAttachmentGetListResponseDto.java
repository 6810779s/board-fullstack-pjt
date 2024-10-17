package board.pjt.back.dto.projectAttachment;

import java.util.Objects;

public class ProjectAttachmentGetListResponseDto {
    private String file_name;
    private String file_path;
    private String file_type;

    public ProjectAttachmentGetListResponseDto() {
    }

    public ProjectAttachmentGetListResponseDto(String file_name, String file_path, String file_type) {
        this.file_name = file_name;
        this.file_path = file_path;
        this.file_type = file_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectAttachmentGetListResponseDto that = (ProjectAttachmentGetListResponseDto) o;
        return Objects.equals(file_name, that.file_name) && Objects.equals(file_path, that.file_path) && Objects.equals(file_type, that.file_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file_name, file_path, file_type);
    }

    @Override
    public String toString() {
        return "ProjectAttachmentGetListResponseDto{" +
                "file_name='" + file_name + '\'' +
                ", file_path='" + file_path + '\'' +
                ", file_type='" + file_type + '\'' +
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

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }
}
