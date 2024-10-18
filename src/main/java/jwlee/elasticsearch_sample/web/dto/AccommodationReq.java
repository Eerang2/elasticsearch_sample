package jwlee.elasticsearch_sample.web.dto;

import jwlee.elasticsearch_sample.domain.enums.AccommodationType;
import jwlee.elasticsearch_sample.domain.model.ParkingInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AccommodationReq {

    @Getter
    public static class Create {

        private String name;
        private String description;
        private String locationGuideText;
        private ParkingInfo parkingInfo;
        private AccommodationType AccommodationType;

        @Builder
        public Create(String name, String description, String locationGuideText, ParkingInfo parkingInfo, jwlee.elasticsearch_sample.domain.enums.AccommodationType accommodationType) {
            this.name = name;
            this.description = description;
            this.locationGuideText = locationGuideText;
            this.parkingInfo = parkingInfo;
            AccommodationType = accommodationType;
        }
    }

}
