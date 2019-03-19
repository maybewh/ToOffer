package com.offer.face45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * �������ų���С����
 * ��Ŀ������һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ�������������Сһ����
 * ���磺��������{3��32��321}�����ӡ��3���������ųɵ���С����321323
 *
 * ����˼·��������ת��Ϊ�ַ�����Ȼ������ַ����Ĺ����������
 *   �������3�����ֵ������[3,32,321]�����������бȽϣ�332 > 323 �����Ҫ������ı�λ[32,3,321]��
 *   3321 > 3213�����ǽ�3 �� 321 ��������λ�õ�[321��32��3]����ʱ�������������������321323����Ϊ��С����
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

