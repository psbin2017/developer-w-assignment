package com.assignment.util;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TextModifier {

    public static String process(String html) {
        String alphabet = onlyAlphabet(html);
        String number = onlyNumber(html);

        return mixedAlphabetAndNumber(
            sortAscendingAlphabet(alphabet),
            sortAscendingNumber(number)
        );
    }

    public static String removeHtmlTag(String html) {
        return html.replaceAll("<[^>]*>","");
    }

    public static String onlyAlphabet(String html) {
        return html.replaceAll("[^a-zA-Z]", "");
    }

    public static String onlyNumber(String body) {
        return body.replaceAll("[^0-9]", "");
    }

    public static String sortAscendingNumber(String html) {
        List<String> result = html.chars()
                                    .sorted()
                                    .map(Character::getNumericValue)
                                    .mapToObj(Integer::toString)
                                    .collect(Collectors.toList());

        return String.join("", result);
    }

    public static String sortAscendingAlphabet(String html) {
        List<Character> chars = html.chars()
                .mapToObj(e -> (char) e)
                .sorted((o1, o2) -> {
                    if ( o1 == o2 ) {
                        return 0;
                    }

                    boolean o1Lower = isLowerCase(o1);
                    boolean o2Lower = isLowerCase(o2);
                    if (o1Lower && o2Lower) {
                        return o1 > o2 ? 1 : -1;
                    } else if (o1Lower) {
                        char x1 = (char) (o1 - 32);
                        return x1 >= o2 ? 1 : -1;
                    } else if (o2Lower) {
                        char x2 = (char) (o2 - 32);
                        return o1 > x2 ? 1 : -1;
                    }
                    return o1 > o2 ? 1 : -1;
                }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Character ch: chars)  {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static String mixedAlphabetAndNumber(String alphabet, String number) {
        char[] alphabetArray = alphabet.toCharArray();
        char[] numberArray = number.toCharArray();

        StringBuilder sb = new StringBuilder();

        int index = 0;
        if ( alphabetArray.length > numberArray.length ) {
            for (char num : numberArray) {
                sb.append(alphabetArray[index++]);
                sb.append(num);
            }
            for ( int i = index; i < alphabetArray.length; i++ ) {
                sb.append(alphabetArray[index++]);
            }
            return sb.toString();
        } else {
            for (char alpha : alphabetArray) {
                sb.append(alpha);
                sb.append(numberArray[index++]);
            }
            for ( int i = index; i < numberArray.length; i++ ) {
                sb.append(numberArray[index++]);
            }
            return sb.toString();
        }
    }

    private static boolean isLowerCase(Character c) {
        return c > 96;
    }

}