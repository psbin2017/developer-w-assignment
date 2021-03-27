package com.assignment.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TextReplacer {

    /**
     * 문자열 중 태그를 없앲니다.
     */
    public static String removeHtmlTag(String html) {
        return html.replaceAll("<[^>]*>", "");
    }

    /**
     * 문자열 중 알파벳만 남깁니다.
     */
    public static String onlyAlphabet(String html) {
        return html.replaceAll("[^a-zA-Z]", "");
    }

    /**
     * 문자열 중 숫자만 남깁니다.
     */
    public static String onlyNumber(String html) {
        return html.replaceAll("[^0-9]", "");
    }

}
