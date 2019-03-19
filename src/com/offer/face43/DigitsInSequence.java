package com.offer.face43;

/**
 * 题目：数字以0123456789101112131415...的格式序列化到一个字符序列中。在这个序列中，第5位是5，第13位是1，第19位是4，等等。
 *   请写一个函数，求任意第n位对应的数字
 *
 *   第一种枚举思路：从0开始逐一枚举每个数字。每枚举一个数字时，求出该数字是几位数，并把该数字的位数和前面所有数字的位数相加，
 *   若小于n，则继续枚举。若大于n，这说明要找的第n位数字一定在数字里面。
 *   第二种思路：比如，第1001位是多少呢
 *     序列的前10位是0~9 这个只有一位数字。显然第1001位在这10个数字之后，因此这10个数字可以直接跳过。
 *   我们再从后面紧跟着的序列中找第991位的数字
 *      接下来180位的数字是90个10~99的两位数，由于991>80，故继续往前找。
 *      接下来的是2700位是900个三位数100~999，由于811 < 2700,故在此范围内，而811 = 270 * 3 + 1,故应该是370的中间一位，7
 *
 */
public class DigitsInSequence {

    public int digitAtIndex(int index){
        if(index < 0)
            return -1;

        //标识到那位（个、十、百、千）
        int digits = 1;
        int ind = index;
        while(true){
            int numbers = countOfIntegers(digits);
            if(ind < digits * numbers){
                if(digits == 1){
                    return ind;
                }else{
                    int base = ind / digits;
                    int remainder = ind % digits;
                    int digit = (int)Math.pow(10,digits - 1) + base;

                    int compute = digits - remainder;
                    int result = digit;
                    int computeRemainder = digit;
                    for (int i = 0; i < compute;i++){
                        result = result / 10;
                        int returnRemainder =  computeRemainder % 10;
                        computeRemainder = result;
                        if(i == compute -1){
                            return  returnRemainder;
                        }
                    }
                }
            }
            ind -= digits * numbers;
            digits++;
        }
    }

    private int countOfIntegers(int digits) {
        if(digits == 1)
            return 10;
        int count = (int)Math.pow(10,digits -1);
        return 9 * count;
    }

    public static void main(String[] args) {
        DigitsInSequence dis = new DigitsInSequence();
        System.out.printf("result:" + dis.digitAtIndex(21));
    }
}
