package com.algorithm.swordoffer.impl;

/**
 * @Description 替换字符串中的空格
 * @Author zhenxing.dong
 * @Date 2020/3/20 17:11
 */
public class ReplaceBlank {
    /**
     * 使用StringBuffer
     *
     * @param input
     * @return
     */
    public static String replaceBlank1(String input) {
        if ("".equals(input) || null == input) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();

        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(String.valueOf(input.charAt(index)));
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 从后往前复制
     * @param input
     * @return
     */
    public static String replaceBlank2(String input) {
        if ("".equals(input) || null == input) {
            return null;
        }

        int blankNum = 0;

        for (int i=0;i<input.length();i++){
            if (' ' == input.charAt(i)){
                blankNum++;
            }
        }
        //每个空格字符串长度加2
        char[] newChar = new char[input.length()+blankNum*2];

        int newCharIndex = newChar.length-1;
        for (int index = input.length()-1;index >= 0;index--){
            if (input.charAt(index) == ' '){
                newChar[newCharIndex--] = '0';
                newChar[newCharIndex--] = '2';
                newChar[newCharIndex--] = '%';
            }else {
                newChar[newCharIndex--] = input.charAt(index);
            }
        }
        return new String(newChar);
    }

    }
