package board.pjt.back.dao;

import board.pjt.back.dto.user.CustomUserDetails;
import board.pjt.back.dto.user.UserResponseDto;
import board.pjt.back.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserMapper userMapper;

    public CustomUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserResponseDto userData = userMapper.select(email);
        if (userData != null) {
            return new CustomUserDetails(userData);
        }
        return null;
    }
}
