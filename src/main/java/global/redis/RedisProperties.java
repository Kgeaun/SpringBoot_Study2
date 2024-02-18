package global.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@AllArgsConstructor
@Configuration("spring.redis")
public class RedisProperties {

    private final String host;
    private final int port;
}