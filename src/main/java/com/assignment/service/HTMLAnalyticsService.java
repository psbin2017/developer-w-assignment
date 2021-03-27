package com.assignment.service;

import com.assignment.util.HTMLAnalyser;
import com.assignment.util.TextReplacer;
import com.assignment.util.TextResultDivider;
import com.assignment.web.dto.SearchRequest;
import com.assignment.web.dto.SearchResponse;
import com.assignment.web.dto.SearchType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class HTMLAnalyticsService {

    private final RestTemplate restTemplate;

    public SearchResponse analysis(SearchRequest request) {

        ResponseEntity<String> responseEntity = restTemplate.exchange(request.getUrl(), HttpMethod.GET, null, String.class);
        if ( responseEntity == null || responseEntity.getBody() == null ) {
            return SearchResponse.builder().division("").remainder("").build();
        }

        String html = responseEntity.getBody();
        if ( request.getType() == SearchType.HTML ) {
            html = TextReplacer.removeHtmlTag(html);
        }

        return TextResultDivider.response(HTMLAnalyser.process(html), request.getUnit());
    }

}
