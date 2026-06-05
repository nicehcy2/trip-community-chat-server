package java.com.trip.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig {

    private final String REDIS_HOST;
    private final Integer REDIS_PORT;

    public RedisConfig(
            @Value("${spring.data.redis.host}") String REDIS_HOST,
            @Value("${spring.data.redis.port}") int REDIS_PORT)
    {

        this.REDIS_HOST = REDIS_HOST;
        this.REDIS_PORT = REDIS_PORT;
    }

    /**
     * RedisConnectionFactory 빈 정의.
     * Redis 서버와의 물리적 연결을 생성 및 관리합니다.
     * LettuceConnectionFactory를 사용하여 Redis와 연결합니다.
     *
     * @return RedisConnectionFactory - Redis와의 연결 팩토리 객체
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {

        return new LettuceConnectionFactory(REDIS_HOST, REDIS_PORT);
    }
}
