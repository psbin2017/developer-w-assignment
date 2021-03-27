package com.assignment.util;

import java.util.List;
import java.util.stream.Collectors;

public class TextSorter {

    public static String sortAscendingNumber(String onlyNumberText) {
        List<String> result = onlyNumberText.chars()
                                        .sorted()
                                        .map(Character::getNumericValue)
                                        .mapToObj(Integer::toString)
                                        .collect(Collectors.toList());

        return listToString(result);
    }

    public static String sortAscendingAlphabet(String html) {
        List<Character> chars = html.chars()
                                        .mapToObj(e -> (char) e)
                                        .sorted(new CustomAlphabetComparator())
                                        .collect(Collectors.toList());

        return listToString(chars);
    }

    private static <T> String listToString(List<T> list) {
        StringBuilder sb = new StringBuilder(list.size());
        for (T t : list) {
            sb.append(t);
        }
        return sb.toString();
    }

}
