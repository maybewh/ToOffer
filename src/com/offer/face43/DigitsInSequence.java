package com.offer.face43;

/**
 * ��Ŀ��������0123456789101112131415...�ĸ�ʽ���л���һ���ַ������С�����������У���5λ��5����13λ��1����19λ��4���ȵȡ�
 *   ��дһ���������������nλ��Ӧ������
 *
 *   ��һ��ö��˼·����0��ʼ��һö��ÿ�����֡�ÿö��һ������ʱ������������Ǽ�λ�������Ѹ����ֵ�λ����ǰ���������ֵ�λ����ӣ�
 *   ��С��n�������ö�١�������n����˵��Ҫ�ҵĵ�nλ����һ�����������档
 *   �ڶ���˼·�����磬��1001λ�Ƕ�����
 *     ���е�ǰ10λ��0~9 ���ֻ��һλ���֡���Ȼ��1001λ����10������֮�������10�����ֿ���ֱ��������
 *   �����ٴӺ�������ŵ��������ҵ�991λ������
 *      ������180λ��������90��10~99����λ��������991>80���ʼ�����ǰ�ҡ�
 *      ����������2700λ��900����λ��100~999������811 < 2700,���ڴ˷�Χ�ڣ���811 = 270 * 3 + 1,��Ӧ����370���м�һλ��7
 *
 */
public class DigitsInSequence {

    public int digitAtIndex(int index){
        if(index < 0)
            return -1;

        //��ʶ����λ������ʮ���١�ǧ��
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
