package com.assignment.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SearchRequest {

    private String url;

    private SearchType type;

    private int unit;

    @Builder
    public SearchRequest(String url, SearchType type, int unit) {
        this.url = url;
        this.type = type;
        this.unit = unit;
    }
}
