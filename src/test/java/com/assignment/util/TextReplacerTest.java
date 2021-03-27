package com.assignment.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextReplacerTest {

    @Test
    public void 열림_닫힘_쌍인_태그를_잘_없애는지() throws Exception {
        // given
        String given = "<h1>hello</h1>";

        // when
        String actual = TextReplacer.removeHtmlTag(given);
        String expected = "hello";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 여닫힘이_하나인_태그를_잘_없애는지() throws Exception {
        // given
        String given = "<input type=\"text\" id=\"url\" name=\"url\" />hello";

        // when
        String actual = TextReplacer.removeHtmlTag(given);
        String expected = "hello";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 문자열에서_알파벳만_잘_남기는지() throws Exception {
        // given
        String given = "R2678925Y@@%*@)A!#(!!#Nㅁ나여ㅐ뵤ㅑㅐa783903460p<><>e!!#(a4890c#*!)($h";

        // when
        String actual = TextReplacer.onlyAlphabet(given);
        String expected = "RYANapeach";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 빈_문자열도_문제가_없는지_onlyAlphabet() throws Exception {
        // given
        String given = "";

        // when
        String actual = TextReplacer.onlyAlphabet(given);
        String expected = "";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 문자열에서_숫자만_잘_남기는지() throws Exception {
        // given
        String given = "15EWRUWEIRO8ㅁㄴ랴ㅐㅁ네ㅑ레ㅐ9012sdusdiofuois5710$*#($*)(29ASSJADI5";

        // when
        String actual = TextReplacer.onlyNumber(given);
        String expected = "15890125710295";

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 빈_문자열도_문제가_없는지_onlyNumber() throws Exception {
        // given
        String given = "";

        // when
        String actual = TextReplacer.onlyNumber(given);
        String expected = "";

        // then
        assertEquals(expected, actual);
    }

}