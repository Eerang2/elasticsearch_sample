package jwlee.elasticsearch_sample.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccommodationType {
    HOTEL("MOTEL"), MOTEL("HOTEL");
    private String value;
}
