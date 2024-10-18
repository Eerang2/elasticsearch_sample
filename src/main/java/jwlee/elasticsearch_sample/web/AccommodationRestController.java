package jwlee.elasticsearch_sample.web;

import jakarta.validation.Valid;
import jwlee.elasticsearch_sample.domain.enums.AccommodationType;
import jwlee.elasticsearch_sample.domain.enums.ParkingType;
import jwlee.elasticsearch_sample.domain.model.Accommodation;
import jwlee.elasticsearch_sample.domain.model.ParkingInfo;
import jwlee.elasticsearch_sample.domain.service.AccommodationService;
import jwlee.elasticsearch_sample.web.dto.AccommodationReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccommodationRestController {

    private final AccommodationService accommodationService;

    @PostMapping("/accommodation/create")
    public ResponseEntity<String> create(@ModelAttribute @Valid AccommodationReq.Create req) {
        log.info("Create accommodation [{}]", req);
        Accommodation accommodation = Accommodation.builder()
                .name(req.getName())
                .description(req.getDescription())
                .AccommodationType(req.getAccommodationType())
                .locationGuideText(req.getLocationGuideText())
                .parkingInfo(ParkingInfo.builder()
                        .isFree(req.getParkingInfo().isFree())
                        .type(req.getParkingInfo().getType())
                        .build())
                .build();
       accommodationService.saveAcc(accommodation);
       return ResponseEntity.ok("success");
    }

    @ModelAttribute("parkingInfo")
    private ParkingType[] parkingTypes() {
        return ParkingType.values();
    }

    @ModelAttribute("accommodationType")
    private AccommodationType[] accommodationTypes() {
        return AccommodationType.values();
    }


}
