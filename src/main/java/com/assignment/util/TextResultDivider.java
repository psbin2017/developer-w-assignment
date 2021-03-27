package com.assignment.util;

import com.assignment.web.dto.SearchResponse;

public class TextResultDivider {

    /**
     * 문자열을 단위로 나누어 몪과 나머지 값 응답 객체로 가공합니다.
     */
    public static SearchResponse response(String origin, int unit) {
        int length = origin.length();
        unit = Math.max(unit, 1);

        if (length < unit) {
            return SearchResponse.builder()
                    .division("")
                    .remainder(origin)
                    .build();
        }

        int middle = length % unit;
        return SearchResponse.builder()
                .division(origin.substring(0, length - middle))
                .remainder(origin.substring(length - middle, length))
                .build();
    }

}
