package com.assignment.web;

import com.assignment.service.HTMLAnalyticsService;
import com.assignment.web.dto.SearchRequest;
import com.assignment.web.dto.SearchResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IndexApi {

    private final HTMLAnalyticsService htmlAnalyticsService;

    @PostMapping("/assignment")
    public SearchResponse find(@RequestBody SearchRequest request) {
        return htmlAnalyticsService.analysis(request);
    }

}
