package jwlee.elasticsearch_sample.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jwlee.elasticsearch_sample.domain.enums.AccommodationType;
import jwlee.elasticsearch_sample.domain.enums.ParkingType;
import jwlee.elasticsearch_sample.domain.model.Accommodation;
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

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CreateFormType {

        @NotBlank(message = "이름은 필수입니다.")
        private String name;

        @NotNull
        private String description;

        @NotNull
        private String locationGuideText;

        private Boolean isFree;

        private ParkingType parkingType;

        @NotNull
        private AccommodationType accommodationType;

        @Builder
        public CreateFormType(String name, String description, String locationGuideText, Boolean isFree, ParkingType parkingType, AccommodationType accommodationType) {
            this.name = name;
            this.description = description;
            this.locationGuideText = locationGuideText;
            this.isFree = isFree;
            this.parkingType = parkingType;
            this.accommodationType = accommodationType;
        }

        public Accommodation toAccommodation() {
            return Accommodation.builder()
                    .name(this.name)
                    .description(description)
                    .AccommodationType(accommodationType)
                    .locationGuideText(this.locationGuideText)
                    .parkingInfo(ParkingInfo.builder()
                            .isFree(this.isFree)
                            .type(this.parkingType)
                            .build())
                    .build();
        }
    }
}
