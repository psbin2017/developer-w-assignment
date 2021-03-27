package com.assignment.util;

public class HTMLAnalyser {

    public static String process(String html) {
        if ( html.isEmpty() ) {
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