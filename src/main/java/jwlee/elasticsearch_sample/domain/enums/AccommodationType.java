package jwlee.elasticsearch_sample.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AccommodationType {
    HOTEL("MOTEL"), MOTEL("HOTEL");
    private String value;
}
