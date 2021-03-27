package com.assignment.web.dto;

public class SearchRequestBuilder {

    private static final String URL = "https://github.com/psbin2017/developer-w-assignment";
    private static final SearchType SEARCH_TYPE = SearchType.HTML;
    private static final int UNIT = 10;

    public static SearchRequest url(String url) {
        return SearchRequest.builder().url(url).type(SEARCH_TYPE).unit(UNIT).build();
    }

    public static SearchRequest type(SearchType searchType) {
        return SearchRequest.builder().url(URL).type(searchType).unit(UNIT).build();
    }

    public static SearchRequest unit(int unit) {
        return SearchRequest.builder().url(URL).type(SEARCH_TYPE).unit(unit).build();
    }

}