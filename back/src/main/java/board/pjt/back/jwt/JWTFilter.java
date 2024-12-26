package board.pjt.back.jwt;


import board.pjt.back.dto.user.CustomUserDetails;
import board.pjt.back.dto.user.UserResponseDto;
import board.pjt.back.enums.Role;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.http.Cookie;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {
    private final JWTUtil jwtUtil;

    public JWTFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //request에서 Authorization 헤더를 찾음

            // 1. Authorization 헤더에서 토큰을 확인
            String authorization = request.getHeader("Authorization");
            String token = null;
            System.out.println("token="+token);
            if (authorization != null && authorization.startsWith("Bearer ")) {
                token = authorization.split(" ")[1];
            } else {
                // 2. Authorization 헤더가 없으면 쿠키에서 JWT를 찾아봄
                Cookie[] cookies = request.getCookies();
                System.out.println("cookies="+cookies);
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if ("token".equals(cookie.getName())) { // 쿠키 이름은 'token'이라고 가정
                            token = cookie.getValue();
                            break;
                        }
                    }
                }
            }

            if (token == null) {
                // 토큰이 없으면 필터를 진행하지 않음
                filterChain.doFilter(request, response);
                return;
            }

            // 3. 토큰이 만료되었으면 새로 발급하여 헤더에 포함시킴
            if (jwtUtil.isExpired(token)) {
                System.out.println("토큰 재발급");
                try {
                    String newToken = jwtUtil.refreshJwt(token);
                    response.setHeader("Authorization", "Bearer " + newToken);
                    // 혹은 쿠키에 새 토큰을 다시 설정할 수도 있음
                    Cookie newCookie = new Cookie("token", newToken);
                    newCookie.setHttpOnly(true);
                    newCookie.setSecure(true);
                    newCookie.setPath("/");
                    newCookie.setMaxAge(60 * 60); // 1시간 동안 유효
                    response.addCookie(newCookie);

                } catch (RuntimeException e) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
                    return;
                }
            }

            // 4. 토큰에서 사용자 정보 추출
            String email = jwtUtil.getEmail(token);
            String role = jwtUtil.getRole(token);
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setEmail(email);
            userResponseDto.setRole(Role.valueOf(role));
            userResponseDto.setPassword("tempPassword"); // 비밀번호는 예시로 설정 (보안상 실제로 이렇게 하지는 않습니다)

            // 5. 사용자 인증 정보 생성
            CustomUserDetails customUserDetails = new CustomUserDetails(userResponseDto);
            Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());

            // 6. 인증 정보를 SecurityContext에 설정
            SecurityContextHolder.getContext().setAuthentication(authToken);

            // 7. 필터 체인에 요청을 전달
            filterChain.doFilter(request, response);
        }

}
