package jwlee.elasticsearch_sample.domain.model;

import jwlee.elasticsearch_sample.domain.enums.AccommodationType;
import jwlee.elasticsearch_sample.domain.repository.entity.AccommodationEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accommodation {
    private long id;
    private String name;
    private String description;
    private String locationGuideText;
    private ParkingInfo parkingInfo;
    private AccommodationType AccommodationType;

    public static Accommodation from(AccommodationEntity entity) {
        return Accommodation.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .parkingInfo(new ParkingInfo(entity.isFreeParking(), entity.getParkingType()))
                .AccommodationType(entity.getAccommodationType())
                .locationGuideText(entity.getLocationGuideText())
                .build();
    }

    public AccommodationEntity toEntity() {
        return AccommodationEntity.builder()
                .id(this.id)
                .name(this.name)
                .isFreeParking(this.parkingInfo.isFree())
                .parkingType(this.parkingInfo.getType())
                .description(this.description)
                .locationGuideText(this.locationGuideText)
                .accommodationType(this.AccommodationType)
                .build();
    }
}
