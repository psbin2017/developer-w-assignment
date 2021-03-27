package com.assignment.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextCombinerTest {

    @Test
    public void 문자열을_번갈아가며_잘_합치는지_1() throws Exception {
        // given
        String front = "AaBbCcDDeeFf";
        String back = "000111222333444555666777888999";

        // when
        String actual = TextCombiner.mergeInSequence(front, back);
        String expected = "A0a0B0b1C1c1D2D2e2e3F3f3444555666777888999";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 문자열을_번갈아가며_잘_합치는지_2() throws Exception {
        // given
        String front = "AaBbCcDDeezcziobuiosetioyuioDDeeFfETUASDIOZXYCOI";
        String back = "000111222333444555666777888999";

        // when
        String actual = TextCombiner.mergeInSequence(front, back);
        String expected = "A0a0B0b1C1c1D2D2e2e3z3c3z4i4o4b5u5i5o6s6e6t7i7o7y8u8i8o9D9D9eeFfETUASDIOZXYCOI";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 한쪽_문자열이_비어도_정상_반환하는지_1() throws Exception {
        // given
        String front = "";
        String back = "000111222333444555666777888999";

        // when
        String actual = TextCombiner.mergeInSequence(front, back);
        String expected = "000111222333444555666777888999";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 한쪽_문자열이_비어도_정상_반환하는지_2() throws Exception {
        // given
        String front = "ZzAbCcbEDYyGDkqowOpz";
        String back = "";

        // when
        String actual = TextCombiner.mergeInSequence(front, back);
        String expected = "ZzAbCcbEDYyGDkqowOpz";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 두_문자열이_비어도_정상_반환하는지() throws Exception {
        // given
        String front = "";
        String back = "";

        // when
        String actual = TextCombiner.mergeInSequence(front, back);
        String expected = "";

        // then
        assertEquals(expected, actual);
    }

}