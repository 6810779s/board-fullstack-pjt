package board.pjt.back.dao;

import board.pjt.back.dto.profileImage.ProfileImageCreateRequestDto;
import board.pjt.back.dto.profileImage.ProfileImageGetResponseDto;
import board.pjt.back.dto.profileImage.ProfileImageUpdateRequestDto;
import board.pjt.back.mapper.ProfileImageMapper;
import org.springframework.stereotype.Service;

@Service
public class ProfileImageDao {
    private final ProfileImageMapper profileImageMapper;

    public ProfileImageDao(ProfileImageMapper profileImageMapper) {
        this.profileImageMapper = profileImageMapper;
    }
    public void createProfileImage(ProfileImageCreateRequestDto requestDto){
        profileImageMapper.createProfileImage(requestDto);
    }


    public ProfileImageGetResponseDto getProfileImage(String email){
        ProfileImageGetResponseDto profileImage = profileImageMapper.getProfileImage(email);
        return profileImage;
    }

    public void updateProfileImage(ProfileImageUpdateRequestDto requestDto){
        profileImageMapper.updateProfileImage(requestDto);
    }

    public void deleteProfileImage(String email){
        profileImageMapper.deleteProfileImage(email);
    }

    public String getProfileImagePathByEmail(String email){
        return profileImageMapper.getProfileImagePathByEmail(email);
    }
}
