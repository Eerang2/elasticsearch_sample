package jwlee.elasticsearch_sample.domain.model;

import jwlee.elasticsearch_sample.domain.enums.ParkingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingInfo {

    private boolean isFree;
    private ParkingType type;
}
