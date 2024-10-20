package jwlee.common;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;

public abstract class BaseRedisTest extends BaseTest {
    static final String REDIS_IMAGE = "redis:latest";
    static final GenericContainer<?> REDIS_CONTAINER;

    static {
        REDIS_CONTAINER = new GenericContainer<>(REDIS_IMAGE)
                .withExposedPorts(6379)
                .withReuse(true);
        REDIS_CONTAINER.start();
    }

    @DynamicPropertySource
    public static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("redis.host", REDIS_CONTAINER::getHost);
        registry.add("redis.port", () -> REDIS_CONTAINER.getMappedPort(6379));
    }
}
