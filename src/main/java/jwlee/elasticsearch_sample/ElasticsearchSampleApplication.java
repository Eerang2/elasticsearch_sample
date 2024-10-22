package jwlee.elasticsearch_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
public class ElasticsearchSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchSampleApplication.class, args);
    }

}
