package jwlee.elasticsearch_sample.domain.model;

import jwlee.elasticsearch_sample.domain.enums.ParkingType;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingInfo {
    private Boolean isFree;
    private ParkingType type;
}
