package com.assignment.util;

import java.util.Comparator;

public final class CustomAlphabetComparator implements Comparator<Character> {

    private static final Integer ASCII_a_ALPHABET = 97;

    private static final Integer ASCII_a_TO_A_CHAR = 32;

    /**
     * 알파벳을 정렬합니다.
     * <p>
     * 1. 알파벳이 둘 다 같은 대문자, 소문자면 그대로 비교하여 정렬합니다.
     * 2. 한쪽이 소문자면 대문자로 변환하여 비교합니다.
     */
    @Override
    public int compare(Character o1, Character o2) {
        if (o1 == o2) {
            return 0;
        }

        boolean isO1LowerCase = isLowerCase(o1);
        boolean isO2LowerCase = isLowerCase(o2);

        if (isO1LowerCase && isO2LowerCase) {
            return o1 > o2 ? 1 : -1;
        } else if (isO1LowerCase) {
            char x1 = (char) (o1 - ASCII_a_TO_A_CHAR);
            return x1 >= o2 ? 1 : -1;
        } else if (isO2LowerCase) {
            char x2 = (char) (o2 - ASCII_a_TO_A_CHAR);
            return o1 > x2 ? 1 : -1;
        }
        return o1 > o2 ? 1 : -1;
    }

    private boolean isLowerCase(Character alphabet) {
        return alphabet >= ASCII_a_ALPHABET;
    }
}
