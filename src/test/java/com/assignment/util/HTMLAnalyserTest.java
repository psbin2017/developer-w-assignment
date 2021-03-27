package com.assignment.util;

import com.assignment.test.FileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HTMLAnalyserTest {
    
    @Test
    public void HTML_파일을_읽어_잘_처리하는지() throws Exception {
        // given
        String given = FileReader.read("/static/test/sample1.html");

        // when
        String actual = HTMLAnalyser.process(given);
        String expected = "A0a0a0a1a1a1a8aaaaaaaaaabbbbCccccccccccDdddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeFgghhhhhhhhhiiiiiiiiiiiiiiilllllllllllllmmmmmmmmmmmmmmmnnnnnnnnnnnoooooooooppppqrrrssssssTttttttttttttttttttttttttUUuuuuuvvvwwwXxyyy";
        
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void HTML_파일을_읽어_잘_처리하는지2() throws Exception {
        // given
        String given = FileReader.read("/static/test/sample2.text");

        // when
        String actual = HTMLAnalyser.process(given);
        String expected = "";

        // then
        assertEquals(expected, actual);
    }
    
    @Test
    public void 빈_문자열도_문제가_없는지() throws Exception {
        // given
        String given = "";

        // when
        String actual = HTMLAnalyser.process(given);
        String expected = "";

        // then
        assertEquals(expected, actual);
    }

}