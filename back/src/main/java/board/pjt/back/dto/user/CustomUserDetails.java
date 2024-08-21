package board.pjt.back.dto.user;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private final UserResponseDto userResponseDto;

    public CustomUserDetails(UserResponseDto userResponseDto) {
        this.userResponseDto = userResponseDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //role 값
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userResponseDto.getRole().name();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return userResponseDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userResponseDto.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() { // 계정 만료 확인
        return true; //true로 임시 설정
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
