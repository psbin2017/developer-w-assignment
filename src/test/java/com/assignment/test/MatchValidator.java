package com.assignment.test;

import java.util.regex.Pattern;

public class MatchValidator {

    private static final Pattern POSITIVE = Pattern.compile("^[0-9a-z-A-Z]*$");

    private static final Pattern NEGATIVE = Pattern.compile("^[가-힣]*$");

    public static boolean isPositive(String text) {
        if ( isEmptyString(text) ) {
            return true;
        }
        return POSITIVE.matcher(text).find();
    }

    public static boolean isNegative(String text) {
        if ( isEmptyString(text) ) {
            return false;
        }
        return NEGATIVE.matcher(text).find();
    }

    private static boolean isEmptyString(String text) {
        return text == null;
    }

}
