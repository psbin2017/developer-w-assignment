package com.assignment.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchResponse {

    private final String division;

    private final String remainder;

    @Builder
    public SearchResponse(String division, String remainder) {
        this.division = division;
        this.remainder = remainder;
    }

}
