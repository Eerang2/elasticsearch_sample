package jwlee.elasticsearch_sample.domain.mainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home";
        // search 이후에 post 로 넘기고 데이터 검색 후에 get 으로 받기
    }
    @PostMapping("/search")
    public String search() {
        return "redirect:/";
    }

    @GetMapping("/accommodation")
    public String accommodation() {
        return "accommodation";
        // 등록 이후에 post 로 데이터 넘겨서 저장 로직 수행하고
        // get 으로 데이터 넘겨받은 후에 home 에서 데이터 노출
    }
}
