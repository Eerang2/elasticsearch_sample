package jwlee.elasticsearch_sample.domain.mainController;

import jwlee.elasticsearch_sample.domain.model.Accommodation;
import jwlee.elasticsearch_sample.domain.service.AccommodationService;
import jwlee.elasticsearch_sample.web.dto.AccommodationReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

    private AccommodationService accommodationService;

    @Autowired
    public MainController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Accommodation> accommodations = accommodationService.findAll();
        for (Accommodation accommodation : accommodations) {
            log.info(accommodation.toString());
        }
        model.addAttribute("accommodations", accommodations);
        return "home";
        // search 이후에 post 로 넘기고 데이터 검색 후에 get 으로 받기
    }
    @PostMapping("/search")
    public String search() {
        return "redirect:/";
    }

    @GetMapping("/accommodation/create")
    public String accommodation(Model model) {
        model.addAttribute("accommodation", new Accommodation());
        return "accommodation";
        // 등록 이후에 post 로 데이터 넘겨서 저장 로직 수행하고
        // get 으로 데이터 넘겨받은 후에 home 에서 데이터 노출
    }
}
