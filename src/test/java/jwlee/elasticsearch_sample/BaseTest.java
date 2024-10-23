package jwlee.elasticsearch_sample;

import jwlee.elasticsearch_sample.domain.config.RedisCacheConfig;
import jwlee.elasticsearch_sample.domain.config.RedisConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {RedisConfig.class, RedisCacheConfig.class})
public abstract class BaseTest {
}
