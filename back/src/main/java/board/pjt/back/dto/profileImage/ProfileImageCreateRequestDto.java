package board.pjt.back.dto.profileImage;

import java.util.Objects;

public class ProfileImageCreateRequestDto {
    private String email;
    private String file_name;
    private String file_path;
    private String file_extension;

    public ProfileImageCreateRequestDto() {
    }

    public ProfileImageCreateRequestDto(String email, String file_name, String file_path, String file_extension) {
        this.email = email;
        this.file_name = file_name;
        this.file_path = file_path;
        this.file_extension = file_extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileImageCreateRequestDto that = (ProfileImageCreateRequestDto) o;
        return Objects.equals(email, that.email) && Objects.equals(file_name, that.file_name) && Objects.equals(file_path, that.file_path) && Objects.equals(file_extension, that.file_extension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, file_name, file_path, file_extension);
    }

    @Override
    public String toString() {
        return "ProfileImageCreateRequestDto{" +
                "email='" + email + '\'' +
                ", file_name='" + file_name + '\'' +
                ", file_path='" + file_path + '\'' +
                ", file_extension='" + file_extension + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
