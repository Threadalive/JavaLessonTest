package com.algorithm.swordoffer.test;

import com.algorithm.swordoffer.impl.ReplaceBlank;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/20 17:18
 */
public class TestReplaceBlank {
    @Test
    public void testReplaceBlank(){
        String input = "we are happy";
        System.out.println(ReplaceBlank.replaceBlank1(input));
        System.out.println(ReplaceBlank.replaceBlank2(input));
    }
}
