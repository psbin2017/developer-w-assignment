package com.assignment.util;

public class TextReplacer {

    public static String removeHtmlTag(String html) {
        return html.replaceAll("<[^>]*>","");
    }

    public static String onlyAlphabet(String html) {
        return html.replaceAll("[^a-zA-Z]", "");
    }

    public static String onlyNumber(String html) {
        return html.replaceAll("[^0-9]", "");
    }

}
