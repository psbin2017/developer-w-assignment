package com.assignment.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchResponse {

    private String share;

    private String rest;

    @Builder
    public SearchResponse(String share, String rest) {
        this.share = share;
        this.rest = rest;
    }
}
