package java.com.trip.global.interceptor;

import java.com.trip.global.error.ResponseCode;
import java.com.trip.global.error.exception.handler.JwtHandler;
import java.com.trip.global.security.UserPrincipal;
import java.com.trip.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StompSessionInterceptor implements ChannelInterceptor {

    private final JwtUtil jwtUtil;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

        // STOMP 헤더 정보를 래핑합니다.
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        // CONNECT 프레임일 때만 JWT 검증 (연결당 1번만 파싱)
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {

            String bearerToken = accessor.getFirstNativeHeader("Authorization");
            if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
                throw new JwtHandler(ResponseCode.JWT_MALFORMED_TOKEN);
            }

            String token = bearerToken.substring(7); // "Bearer " 제거

            Long userId = jwtUtil.getUserId(token); // JWT 파싱 + 검증 → userId 추출
            accessor.setUser(new UserPrincipal(userId)); // WebSocket 세션에 저장

            log.info("WebSocket 연결 인증 완료. userId: {}", userId);
        } else if (StompCommand.DISCONNECT.equals(accessor.getCommand())) {


        }

        return message;
    }
}
