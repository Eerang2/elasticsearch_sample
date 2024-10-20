package jwlee.elasticsearch_sample.domain.repository;

import jwlee.elasticsearch_sample.domain.repository.entity.AccommodationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<AccommodationEntity, Long> {

    Optional<AccommodationEntity> findAccommodationEntityById(long id);
}
