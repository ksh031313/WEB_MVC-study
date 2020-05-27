package me.seung.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventTest() throws Exception {
        mockMvc.perform(get("/templates/events/123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(123))
                ;
    }

    @Test
    public void eventTest2() throws Exception {
        mockMvc.perform(post("/events2")
        .param("name", "seung"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("seung"))
        ;
    }

}
