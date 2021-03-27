package com.assignment.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextModifierTest {

    @Test
    public void test_removeHtmlTag() throws Exception {
        // given
        String given = "<h1>hello</h1>";

        // when
        String actual = TextModifier.removeHtmlTag(given);
        String expected = "hello";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void test_onlyEnglish() throws Exception {
        // given
        String given = "R2678925Y@@%*@)A!#(!!#Nㅁ나여ㅐ뵤ㅑㅐa783903460p<><>e!!#(a4890c#*!)($h";

        // when
        String actual = TextModifier.onlyAlphabet(given);
        String expected = "RYANapeach";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void test_onlyNumber() throws Exception {
        // given
        String given = "15EWRUWEIRO8ㅁㄴ랴ㅐㅁ네ㅑ레ㅐ9012sdusdiofuois5710$*#($*)(29ASSJADI5";

        // when
        String actual = TextModifier.onlyNumber(given);
        String expected = "15890125710295";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void test_sortNumber() throws Exception {
        // given
        String given = "987654321001234567899876543210";

        // when
        String actual = TextModifier.sortAscendingNumber(given);
        String expected = "000111222333444555666777888999";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void test_sortAscendingEnglish() throws Exception {
        // given
        String given = "eeDDcCBbAafF";

        // when
        String actual = TextModifier.sortAscendingAlphabet(given);
        String expected = "AaBbCcDDeeFf";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void test_mixedAlphabetAndNumber() throws Exception {
        // given
        String alphabet = "AaBbCcDDeeFf";
        String number = "000111222333444555666777888999";

        // when
        String actual = TextModifier.mixedAlphabetAndNumber(alphabet, number);
        String expected = "A0a0B0b1C1c1D2D2e2e3F3f3444555666777888999";

        // then
        assertEquals(expected, actual);
    }

}