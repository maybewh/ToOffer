package com.offer.face44;

/**
 * 输入一个整数，求1-n整数中十进制表示中1出现得次数。如，输入12，1-12中包含1的整数有，1、10，11、12，共出现5次
 * s思路：https://blog.csdn.net/yi_afly/article/details/52012593
 */
public class NumberOf1 {

    public int NumberOf1Between1AndN_Solution(int n) {
        if(n < 1)
            return 0;
        int count = 0;
        int base = 1;
        int round = n;

        while(round > 0){
            int weight = round % 10;
            round = round / 10;

            count += base * round;
            if(weight == 1){
                count += n % base + 1;
            }else if (weight > 1){
                count += base;
            }
            base *= 10;
        }
        return  count;
    }
}

