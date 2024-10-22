package jwlee.elasticsearch_sample.domain.service;

import jakarta.transaction.Transactional;
import jwlee.elasticsearch_sample.domain.exception.NotFoundAccommodationException;
import jwlee.elasticsearch_sample.domain.model.Accommodation;
import jwlee.elasticsearch_sample.domain.repository.AccommodationRepository;
import jwlee.elasticsearch_sample.domain.repository.entity.AccommodationEntity;
import jwlee.elasticsearch_sample.web.dto.AccommodationReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    @Qualifier()
    private final CacheManager cacheManager;

    public Accommodation saveAcc(Accommodation accommodation) {
        AccommodationEntity entity = accommodationRepository.save(accommodation.toEntity());
        return Accommodation.from(entity);
     }

     public List<Accommodation> findAll() {
        List<AccommodationEntity> entities = accommodationRepository.findAll();
        return entities.stream()
                .map(Accommodation::from)
                .collect(Collectors.toList());
     }
    @Transactional
    @Cacheable(cacheNames = "accommodation", key = "#id", cacheManager = "accommodationCacheManager", condition = "#id > 0")
    public Accommodation findAccommodationById(Long id) {
        log.info("before accommodation with id: {}", cacheManager.getCache("accommodation").get(id));
        log.info("before id: {}", id);
        AccommodationEntity accommodationEntity = accommodationRepository.findAccommodationEntityById(id).orElseThrow(NotFoundAccommodationException::new);
        log.info("after accommodation with id: {}", cacheManager.getCache("accommodation").get(id));
        log.info("after id: {}", id);
        return Accommodation.from(accommodationEntity);
    }
}
