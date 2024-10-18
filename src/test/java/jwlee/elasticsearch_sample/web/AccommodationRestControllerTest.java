package jwlee.elasticsearch_sample.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jwlee.common.BaseMockMvcTest;
import jwlee.elasticsearch_sample.domain.enums.AccommodationType;
import jwlee.elasticsearch_sample.domain.enums.ParkingType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccommodationRestControllerTest extends BaseMockMvcTest {


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("숙소 등록 성공")
    void save() throws Exception {
        final ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/accommodation/create")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)  // 폼 데이터 전송 방식
                        .param("name", "신라호텔")
                        .param("description", "5성급 최고급 호텔")
                        .param("accommodationType", AccommodationType.HOTEL.name())
                        .param("isFree", "true")
                        .param("parkingType", ParkingType.MACHINE.name())
                        .param("locationGuideText", "예약 후에 문자 드려요")
        );

        // then
        resultActions.andExpect(status().isOk());
    }

}