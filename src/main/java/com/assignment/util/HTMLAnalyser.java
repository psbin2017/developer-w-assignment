package com.assignment.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HTMLAnalyser {

    /**
     * HTML 문자열을 처리합니다.
     * <p>
     * 1. 문자열에서 알파벳과 숫자로 분리합니다.
     * 2. 각 문자열을 정렬합니다.
     * 3. 정렬한 문자열을 병합합니다.
     */
    public static String process(String html) {
        if (ObjectUtils.isEmpty(html)) {
            return html;
        }

        String alphabet = TextReplacer.onlyAlphabet(html);
        String number = TextReplacer.onlyNumber(html);

        return TextCombiner.mergeInSequence(
                TextSorter.sortAscendingAlphabet(alphabet),
                TextSorter.sortAscendingNumber(number)
        );
    }

}