package com.offer.face51;

import java.util.ArrayList;
import java.util.List;

public class InverseParis2 {
	//�����е������
    public static int InversePairs(int[] array){
        if(array==null||array.length<=1)
            return 0;
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i] = array[i];
        }
        return mergeCount(array, copy, 0, array.length-1);
    }
    
    public static int mergeCount(int[] array, int[] copy, int start, int end){
        if(start==end){
            copy[start] = array[start];
            return 0;
        }
        int mid = (start+end)>>1;
        int leftCount = mergeCount(copy, array, start, mid);
        int rightCount = mergeCount(copy, array, mid+1, end);
        
        int i = mid;//i��ʼ��Ϊǰ������һ�����ֵ��±�
        int j = end;//j��ʼ��Ϊ�������һ�����ֵ��±�
        int index = end;//�������鸴�Ƶ���������һ�����ֵ��±�
        int count = 0;//����--����Ե���Ŀ
        while(i>=start&&j>=mid+1){
            if(array[i]>array[j]){
                copy[index--] = array[i--];
                count += j-mid;
            }else{
                copy[index--] = array[j--];
            }
        }
        for(;i>=start;i--){
            copy[index--] = array[i];
        }
        for(;j>=mid+1;j--){
            copy[index--] = array[j];
        }
        return leftCount+rightCount+count;
    }
    
    public static void main(String[] args) {
		InverseParis2 ip = new InverseParis2();
		System.out.println(ip.InversePairs(new int[] {1,2,3,4,5,6,7,0}));
	}
}
