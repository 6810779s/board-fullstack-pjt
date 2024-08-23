package board.pjt.back.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {
    private final SecretKey secretKey;

    public JWTUtil(@Value("${spring.jwt.secret}") String secret) {
        secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    public String getEmail(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("email", String.class);
    }

    public String getRole(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("role", String.class);
    }

    public Boolean isExpired(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }

    public String refreshJwt(String expiredToken) {
        try {
            // 토큰 파싱 중 만료된 경우 처리
            String email = getEmail(expiredToken);
            String role = getRole(expiredToken);
            System.out.println("토큰 재발급");
            // 새 JWT 생성
            return createJwt(email, role, 600 * 600 * 1000L);  // 1시간의 만료 시간을 가진 새로운 JWT 생성
        } catch (ExpiredJwtException e) {
            // 만료된 토큰의 경우, 새로 발급
            throw new RuntimeException("토큰이 만료되었습니다. 다시 로그인 해주세요.");
        }
    }

    public String createJwt(String email, String role, Long expiredMs) {
        System.out.println("-------------------createJwt email=" + email);

        long currentTime = System.currentTimeMillis(); // 현재 시간 (밀리초)
        long expirationTime = currentTime + expiredMs; // 만료 시간 계산
        return Jwts.builder()
                .claim("email", email)
                .claim("role", role)
                .issuedAt(new Date(currentTime))
                .expiration(new Date(expirationTime))
                .signWith(secretKey) //암호화 진행
                .compact();
    }
}
