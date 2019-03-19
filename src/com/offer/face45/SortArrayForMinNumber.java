package com.offer.face45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出所有数字中最小一个。
 * 例如：输入数组{3，32，321}，则打印这3个数字能排成的最小数字321323
 *
 * 大致思路：将整数转换为字符串，然后根据字符串的规则进行排序。
 *   如对于有3个数字的情况：[3,32,321]我们两两进行比较，332 > 323 因此需要把数组改变位[32,3,321]而
 *   3321 > 3213，于是将3 与 321 继续交换位置到[321，32，3]，此时，将数组链接起来变成321323，即为最小的数
 */
public class SortArrayForMinNumber {

    public String PrintMinNumber(int [] numbers) {

        if(numbers == null || numbers.length == 0 )
            return "";
        String[] strOfNum = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strOfNum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strOfNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numbers.length; i++) {
            stringBuffer.append(strOfNum[i]);
        }

        return stringBuffer.toString();
    }
}

