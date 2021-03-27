package com.assignment.util;

public class TextCombiner {

    public static String mergeInSequence(String front, String back) {
        char[] frontArray = front.toCharArray();
        char[] backArray = back.toCharArray();

        StringBuilder sb = new StringBuilder();
        int index = 0;
        if ( frontArray.length > backArray.length ) {
            for (char num : backArray) {
                sb.append(frontArray[index++]);
                sb.append(num);
            }
            for ( int i = index; i < frontArray.length; i++ ) {
                sb.append(frontArray[index++]);
            }
        } else {
            for (char alpha : frontArray) {
                sb.append(alpha);
                sb.append(backArray[index++]);
            }
            for ( int i = index; i < backArray.length; i++ ) {
                sb.append(backArray[index++]);
            }
        }
        return sb.toString();
    }

}
