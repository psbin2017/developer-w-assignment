package com.assignment.web;

import com.assignment.service.HTMLAnalyticsService;
import com.assignment.web.dto.SearchRequest;
import com.assignment.web.dto.SearchRequestBuilder;
import com.assignment.web.dto.SearchType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @MockBean
    private HTMLAnalyticsService htmlAnalyticsService;

    @Test
    public void 요청이_정상적으로_실행되는지() throws Exception {
        // given
        SearchRequest dto = SearchRequestBuilder.type(SearchType.HTML);

        // when
        ResultActions resultActions = mockMvc.perform(post("/assignment")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(objectMapper.writeValueAsString(dto)))
                                                .andDo(print());

        // then
        resultActions
                .andExpect(status().isOk());
    }

    @Test
    public void 요청이_정상적으로_실행되는지2() throws Exception {
        // given
        SearchRequest dto = SearchRequestBuilder.type(SearchType.TEXT);

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