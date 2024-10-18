package jwlee.elasticsearch_sample.web;

import jwlee.elasticsearch_sample.domain.model.Accommodation;
import jwlee.elasticsearch_sample.domain.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccommodationRestController {

    private final AccommodationService accommodationService;

    @PostMapping("/accommodation/create")
    public Accommodation create() {
        return null;
    }


}
