package com.assignment.service;

import com.assignment.web.dto.SearchRequest;
import com.assignment.web.dto.SearchRequestBuilder;
import com.assignment.web.dto.SearchResponse;
import com.assignment.web.dto.SearchType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.assignment.test.MatchValidator.isNegative;
import static com.assignment.test.MatchValidator.isPositive;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HTMLAnalyticsServiceTest {

    @Autowired
    private HTMLAnalyticsService htmlAnalyticsService;

    @Test
    public void 리포지토리_경로_HTML제외_10단위_묶음() throws Exception {
        // given
        SearchRequest searchRequest = SearchRequestBuilder.unit(20);

        // when
        SearchResponse searchResponse = htmlAnalyticsService.analysis(searchRequest);

        // then
        commonTest(searchResponse);
    }

    @Test
    public void 리포지토리_경로_HTML포함_10단위_묶음() throws Exception {
        // given
        SearchRequest searchRequest = SearchRequestBuilder.type(SearchType.TEXT);

        // when
        SearchResponse searchResponse = htmlAnalyticsService.analysis(searchRequest);

        // then
        commonTest(searchResponse);
    }

    @Test
    public void 네이버_경로_HTML제외_10단위_묶음() throws Exception {
        // given
        SearchRequest searchRequest = SearchRequestBuilder.url("https://naver.com");

        // when
        SearchResponse searchResponse = htmlAnalyticsService.analysis(searchRequest);

        // then
        commonTest(searchResponse);
    }

    @Test
    public void 리포지토리_경로_HTML제외_최대단위_묶음() throws Exception {
        // given
        SearchRequest searchRequest = SearchRequestBuilder.unit(Integer.MAX_VALUE);

        // when
        SearchResponse searchResponse = htmlAnalyticsService.analysis(searchRequest);

        // then
        commonTest(searchResponse);
    }

    @Test
    public void 리포지토리_경로_HTML제외_0단위_묶음의_경우_1로_처리() throws Exception {
        // given
        SearchRequest searchRequest = SearchRequestBuilder.unit(0);

        // when
        SearchResponse searchResponse = htmlAnalyticsService.analysis(searchRequest);

        // then
        commonTest(searchResponse);
    }

    private void commonTest(SearchResponse searchResponse) {
        assertFalse(isNegative(searchResponse.getDivision()));
        assertTrue(isPositive(searchResponse.getDivision()));
        assertFalse(isNegative(searchResponse.getRemainder()));
        assertTrue(isPositive(searchResponse.getRemainder()));
    }
}