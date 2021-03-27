package com.assignment.service;

import com.assignment.util.TextModifier;
import com.assignment.web.dto.SearchDTO;
import com.assignment.web.dto.SearchResponse;
import com.assignment.web.dto.SearchType;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class HTMLAnalyticsService {

    public SearchResponse analysis(SearchDTO request) {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start("rest template");

        RestTemplate restTemplate = new RestTemplate();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        HttpClient httpClient = HttpClientBuilder.create()
                                    .setRedirectStrategy(new LaxRedirectStrategy())
                                    .build();

        factory.setHttpClient(httpClient); restTemplate.setRequestFactory(factory);


        ResponseEntity<String> responseEntity = restTemplate.exchange(request.getUrl(), HttpMethod.GET, null, String.class);
        String html = responseEntity.getBody();

        stopWatch.stop();
        stopWatch.start("remove html tag");

        if ( request.getType() == SearchType.HTML ) {
            html = TextModifier.removeHtmlTag(html);
        }

        stopWatch.stop();

        stopWatch.start("process");

        String pure = TextModifier.process(html);
        int length = pure.length();
        int size = request.getUnit();

        stopWatch.stop();

        log.info( stopWatch.prettyPrint() );

        if ( pure.length() < size ) {
            return SearchResponse.builder()
                                    .share("")
                                    .rest(pure)
                                    .build();
        }

        int middle = pure.length() % size;
        return SearchResponse.builder()
                                .share( pure.substring(0, length - middle) )
                                .rest( pure.substring(length - middle, length) )
                                .build();
    }

}
