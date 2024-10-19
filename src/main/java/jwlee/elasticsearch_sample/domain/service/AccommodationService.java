package jwlee.elasticsearch_sample.domain.service;

import jwlee.elasticsearch_sample.domain.model.Accommodation;
import jwlee.elasticsearch_sample.domain.repository.AccommodationRepository;
import jwlee.elasticsearch_sample.domain.repository.entity.AccommodationEntity;
import jwlee.elasticsearch_sample.web.dto.AccommodationReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
}
