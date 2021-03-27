package com.assignment.util;

import org.springframework.util.ObjectUtils;

public class HTMLAnalyser {

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