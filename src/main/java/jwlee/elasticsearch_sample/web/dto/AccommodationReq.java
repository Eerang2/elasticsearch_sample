package jwlee.elasticsearch_sample.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jwlee.elasticsearch_sample.domain.enums.AccommodationType;
import jwlee.elasticsearch_sample.domain.model.ParkingInfo;
import lombok.*;

import java.beans.ConstructorProperties;

@Getter
public class AccommodationReq {

    @Getter
    @Setter
    public static class Create {

        @NotBlank(message = "이름은 필수입니다.")
        private String name;

        @NotNull
        private String description;

        @NotNull
        private String locationGuideText;

        @NotNull
        private ParkingInfo parkingInfo;

        @NotNull
        private AccommodationType accommodationType;

        @Builder
        public Create(String name, String description, String locationGuideText, ParkingInfo parkingInfo, jwlee.elasticsearch_sample.domain.enums.AccommodationType accommodationType) {
            this.name = name;
            this.description = description;
            this.locationGuideText = locationGuideText;
            this.parkingInfo = parkingInfo;
            this.accommodationType = accommodationType;
        }
    }

}
