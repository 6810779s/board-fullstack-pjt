package board.pjt.back.dto.profileImage;

import java.util.Objects;

public class ProfileImageUpdateRequestDto {
    private String file_name;
    private String file_extension;
    private String file_path;
    private String email;

    public ProfileImageUpdateRequestDto() {
    }

    public ProfileImageUpdateRequestDto(String file_name, String file_extension, String file_path, String email) {
        this.file_name = file_name;
        this.file_extension = file_extension;
        this.file_path = file_path;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileImageUpdateRequestDto that = (ProfileImageUpdateRequestDto) o;
        return Objects.equals(file_name, that.file_name) && Objects.equals(file_extension, that.file_extension) && Objects.equals(file_path, that.file_path) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file_name, file_extension, file_path, email);
    }

    @Override
    public String toString() {
        return "ProfileImageUpdateRequestDto{" +
                "file_name='" + file_name + '\'' +
                ", file_extension='" + file_extension + '\'' +
                ", file_path='" + file_path + '\'' +
                ", email='" + email + '\'' +
                '}';
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

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
