package com.assignment.util;

public class TextCombiner {

    /**
     * front 문자열과 back 문자열을 번갈아가면서 병합합니다.
     * 만약, 한쪽이 다 되면 남은 문자열을 마지막에 붙입니다.
     */
    public static String mergeInSequence(String front, String back) {
        char[] frontArray = front.toCharArray();
        char[] backArray = back.toCharArray();

        StringBuilder sb = new StringBuilder();
        int index = 0;
        if (frontArray.length > backArray.length) {
            for (char num : backArray) {
                sb.append(frontArray[index++]);
                sb.append(num);
            }
            for (int i = index; i < frontArray.length; i++ ) {
                sb.append(frontArray[index++]);
            }
        } else {
            for (char alpha : frontArray) {
                sb.append(alpha);
                sb.append(backArray[index++]);
            }
            for (int i = index; i < backArray.length; i++ ) {
                sb.append(backArray[index++]);
            }
        }
        return sb.toString();
    }

}
