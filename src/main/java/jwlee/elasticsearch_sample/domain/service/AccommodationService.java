package jwlee.elasticsearch_sample.domain.service;

import jwlee.elasticsearch_sample.domain.model.Accommodation;
import jwlee.elasticsearch_sample.domain.repository.AccommodationRepository;
import jwlee.elasticsearch_sample.domain.repository.entity.AccommodationEntity;
import jwlee.elasticsearch_sample.web.dto.AccommodationReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public Accommodation saveAcc(Accommodation accommodation) {
        AccommodationEntity entity = accommodationRepository.save(accommodation.toEntity());
        return Accommodation.from(entity);
     }
}
