package com.assignment.service;

import com.assignment.util.HTMLAnalyser;
import com.assignment.util.TextReplacer;
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
        String html = responseEntity.getBody();

        if ( request.getType() == SearchType.HTML ) {
            html = TextReplacer.removeHtmlTag(html);
        }

        String origin = HTMLAnalyser.process(html);
        int length = origin.length();
        int unit = request.getUnit();

        if ( length < unit ) {
            return SearchResponse.builder()
                    .division( null )
                    .remainder( origin )
                    .build();
        }
        int middle = length % unit;
        return SearchResponse.builder()
                                .division( origin.substring(0, length - middle) )
                                .remainder( origin.substring(length - middle, length) )
                                .build();
    }

}
