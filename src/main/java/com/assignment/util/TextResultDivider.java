package com.assignment.util;

import com.assignment.web.dto.SearchResponse;

public class TextResultDivider {

    public static SearchResponse response(String origin, int unit) {
        int length = origin.length();
        unit = Math.max(unit, 1);

        if ( length < unit ) {
            return SearchResponse.builder()
                    .division( "" )
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
