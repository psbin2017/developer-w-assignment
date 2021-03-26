package com.assignment.web;

import com.assignment.web.dto.SearchDTO;
import com.assignment.web.dto.SearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IndexApi {

    @PostMapping("/assignment")
    public SearchResponse find(@RequestBody SearchDTO request) {
        log.info( request.toString() );
        return SearchResponse.builder()
                                .share("A1a2b3")
                                .rest("4")
                                .build();
    }

}
