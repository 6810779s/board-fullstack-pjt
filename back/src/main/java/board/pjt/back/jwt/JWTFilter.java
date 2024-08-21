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

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {
    private final JWTUtil jwtUtil;

    public JWTFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //request에서 Authorization 헤더를 찾음
        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            System.out.println("token null");
            filterChain.doFilter(request, response);
            //조건이 해당되면 메소드 종료 (필수)
            return;
        }
        String token = authorization.split(" ")[1];
        if (token != null && jwtUtil.isExpired(token)) {
            System.out.println("토큰 재발급");
            try {
                String newToken = jwtUtil.refreshJwt(token);
                response.setHeader("Authorization", "Bearer " + newToken);
            } catch (RuntimeException e) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
                return;
            }
        }
//        if (token != null && jwtUtil.isExpired(token)) {
//            // 만료된 토큰을 확인한 경우 새로운 토큰 생성
//            String newToken = jwtUtil.refreshJwt(token);
//
//            // 새 토큰을 클라이언트로 반환 (예: 응답 헤더에 추가)
//            response.setHeader("Authorization", "Bearer " + newToken);
//        } else if (jwtUtil.isExpired(token)) {
//            System.out.println("token expired");
//            filterChain.doFilter(request, response);
//            return;
//        }
        String email = jwtUtil.getEmail(token);
        String role = jwtUtil.getRole(token);
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setEmail(email);
        userResponseDto.setRole(Role.valueOf(role));
        userResponseDto.setPassword("tempPassword");
        // 비밀번호는 토큰에 담겨있지 않음. 비밀번호도 초기화를 같이 진행해줘야 됨.
        // 근데 비밀번호를 조회할 경우, 매번 요청할 때 마다 db조회를 하는 안좋은 상황이 발생하기 때문에,
        // 여기서(context holder?에서는)는 임시 비밀번호를 넣어줌.

        CustomUserDetails customUserDetails = new CustomUserDetails(userResponseDto);
        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);//필터 체인에 있는 다음 필터로 요청을 전달하기 위해 사용됨.
    }
}
