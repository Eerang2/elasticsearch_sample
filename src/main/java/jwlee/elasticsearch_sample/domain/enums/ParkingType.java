package jwlee.elasticsearch_sample.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum ParkingType {
    FIELD("일반주차장"), MACHINE("기계식주차장"), ETC("기타");
    private String value;
}
