package com.assignment.web;

import com.assignment.web.dto.SearchDTO;
import com.assignment.web.dto.SearchType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IndexApi.class)
public class IndexApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRequest() throws Exception {
        // given
        final SearchDTO dto = SearchDTO.builder()
                                    .url("https://github.com/psbin2017")
                                    .type(SearchType.HTML)
                                    .unit(100)
                                    .build();

        // when
        ResultActions resultActions = mockMvc.perform(post("/assignment")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(objectMapper.writeValueAsString(dto)))
                                                .andDo(print());

        // then
        resultActions
                .andExpect(status().isOk());
    }

}