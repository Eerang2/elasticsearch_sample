package jwlee.elasticsearch_sample.service;

import jakarta.transaction.Transactional;
import jwlee.elasticsearch_sample.BaseRedisTest;
import jwlee.elasticsearch_sample.domain.model.Accommodation;
import jwlee.elasticsearch_sample.domain.repository.AccommodationRepository;
import jwlee.elasticsearch_sample.domain.repository.entity.AccommodationEntity;
import jwlee.elasticsearch_sample.domain.service.AccommodationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
public class AccommodationServiceTest extends BaseRedisTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private AccommodationService accommodationService;

    @Test
    @DisplayName("findAccById 로 API 조회")
    void jpaGetName() {
        AccommodationEntity entity = accommodationRepository.findAccommodationEntityById(1L).get();
        assertEquals("신라호텔", entity.getName());
    }

    @Test
    @DisplayName("숙소 캐시 잘 걸리는지 테스트")
    void accommodationCache() {
        assertThat(cacheManager.getCache("accommodation").get(1L)).isNull();
        Accommodation accommodation = accommodationService.findAccommodationById(1L);
        assertThat(accommodation).isNotNull(); // 캐싱 전 조회된 값 검증
        assertThat(accommodation.getId()).isEqualTo(1L);

        assertThat(cacheManager.getCache("accommodation").get(1L)).isNotNull();
    }
}
