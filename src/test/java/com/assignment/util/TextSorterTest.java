package com.assignment.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextSorterTest {

    @Test
    public void 숫자를_오름차순으로_잘_정렬하는지() throws Exception {
        // given
        String given = "987654321001234567899876543210";

        // when
        String actual = TextSorter.sortAscendingNumber(given);
        String expected = "000111222333444555666777888999";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 알파벳을_요구사항대로_잘_정렬하는지() throws Exception {
        // given
        String given = "eeDDcCBbAafF";

        // when
        String actual = TextSorter.sortAscendingAlphabet(given);
        String expected = "AaBbCcDDeeFf";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 대문자_알파벳만_정렬해도_이상이_없는지() throws Exception {
        // given
        String given = "ASUDIOUAWIOEUIOASZPXFOPOQ";

        // when
        String actual = TextSorter.sortAscendingAlphabet(given);
        String expected = "AAADEFIIIOOOOOPPQSSUUUWXZ";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 소문자_알파벳만_정렬해도_이상이_없는지() throws Exception {
        // given
        String given = "rausiorsndfzeshroiuszoirq";

        // when
        String actual = TextSorter.sortAscendingAlphabet(given);
        String expected = "adefhiiinoooqrrrrssssuuzz";

        // then
        assertEquals(expected, actual);
    }

}