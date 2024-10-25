package board.pjt.back.dto.profileImage;

import java.util.Objects;

public class ProfileImageGetResponseDto {
    private int profile_image_id;
    private String file_extension;
    private String file_name;

    public ProfileImageGetResponseDto() {
    }

    public ProfileImageGetResponseDto(int profile_image_id, String file_extension, String file_name) {
        this.profile_image_id = profile_image_id;
        this.file_extension = file_extension;
        this.file_name = file_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileImageGetResponseDto that = (ProfileImageGetResponseDto) o;
        return profile_image_id == that.profile_image_id && Objects.equals(file_extension, that.file_extension) && Objects.equals(file_name, that.file_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile_image_id, file_extension, file_name);
    }

    @Override
    public String toString() {
        return "ProfileImageGetResponseDto{" +
                "profile_image_id=" + profile_image_id +
                ", file_extension='" + file_extension + '\'' +
                ", file_name='" + file_name + '\'' +
                '}';
    }

    public int getProfile_image_id() {
        return profile_image_id;
    }

    public void setProfile_image_id(int profile_image_id) {
        this.profile_image_id = profile_image_id;
    }

    public String getFile_extension() {
        return file_extension;
    }

    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
