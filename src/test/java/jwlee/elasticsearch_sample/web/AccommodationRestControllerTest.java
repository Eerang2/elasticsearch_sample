package jwlee.elasticsearch_sample.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jwlee.common.BaseMockMvcTest;
import jwlee.elasticsearch_sample.domain.enums.AccommodationType;
import jwlee.elasticsearch_sample.domain.enums.ParkingType;
import jwlee.elasticsearch_sample.domain.model.ParkingInfo;
import jwlee.elasticsearch_sample.web.dto.AccommodationReq;
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
        // given
        String requestBody = objectMapper.writeValueAsString(
                AccommodationReq.Create.builder()
                        .name("신라호텔")
                        .description("5성급 최고급 호텔")
                        .accommodationType(AccommodationType.HOTEL)
                        .parkingInfo(new ParkingInfo(true, ParkingType.MACHINE))
                        .locationGuideText("예약 후에 문자 드려요")
                        .build()
        );

        // when
        final ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/accommodation/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)

        );

        // then
        resultActions.andExpect(status().isOk());
    }

}