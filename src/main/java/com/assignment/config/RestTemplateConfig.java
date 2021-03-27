package com.assignment.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * @Link {https://stackoverflow.com/questions/32392634/spring-resttemplate-redirect-302}
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        HttpClient httpClient = HttpClientBuilder.create()
                                                .setRedirectStrategy(new LaxRedirectStrategy())
                                                .build();
        return restTemplateBuilder
                            .requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient))
                            .build();
    }
}
