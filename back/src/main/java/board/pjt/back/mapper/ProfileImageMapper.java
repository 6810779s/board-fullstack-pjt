package board.pjt.back.mapper;

import board.pjt.back.dto.profileImage.ProfileImageCreateRequestDto;
import board.pjt.back.dto.profileImage.ProfileImageGetResponseDto;
import board.pjt.back.dto.profileImage.ProfileImageUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileImageMapper {
    void createProfileImage(ProfileImageCreateRequestDto requestDto);
    ProfileImageGetResponseDto getProfileImage(String email);

    String getProfileImagePathByEmail(String email);
    void updateProfileImage(ProfileImageUpdateRequestDto requestDto);
    void deleteProfileImage(String email);
}
