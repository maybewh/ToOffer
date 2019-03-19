package com.offer.face20;

import java.util.Arrays;

/**
 * ��������˳��ʹ����λ��ż��ǰ��
 * ��Ŀ������һ�����飬ʵ��һ�����������������������ֵ�˳��ʹ����������λ�������
 *  ǰ�벿�֣�����ż��λ������ĺ�벿��
 * @author admin
 *
 */
public class ReorderArray {
	
	public void reOrderArray(int [] array) {
       int index1 = 0;
       int index2 = array.length - 1;
       
       while(index2 >= 0 && index1 < array.length && index2 > index1) {
    	   if(array[index2] % 2 == 0)
    		   index2--;
    	   if(array[index1] % 2 != 0) 
    		   index1++;
    	   if(array[index2] % 2 != 0 && array[index1] % 2 == 0) {
    		   int temp = array[index2];
    		   array[index2] = array[index1];
    		   array[index1] = temp;
    		   index2--;
    		   index1++;
    	   }
       }
       System.out.println(index2 +" -- " + index1);
    }
	
	/**
	 * ţ�ͣ�����һ���������飬ʵ��һ�����������������������ֵ�˳��
	 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
	 * ����֤������������ż����ż��֮������λ�ò��䡣
	 * @param array
	 */
	public void reOrderArray2(int [] array) {
	       int index1 = 0;
	       int index2 = 1;
	      
	       int evenNum = 0;
	       if(array[0] % 2 ==0) {
	    	   evenNum++;
	       }
	       while(index2 < array.length && index1 < array.length) {
	    	   while(array[index1] % 2 != 0) {
	    		   index1++;
	    	   }
	    	   while(array[index2] % 2 == 0) {
	    		   index2++;
	    		   evenNum++;
	    	   }
	    	   
	    	   if(array[index1] % 2 == 0 && array[index2] % 2 != 0) {
	    		   int temp = array[index2];
	    		   int count = evenNum;
	    		   int i = index2;
	    		   while(count > 0 && i > index1) {
	    			   array[i] = array[i - 1];
	    			   count--;
	    			   i--;
	    		   }
	    		   array[index1] = temp;
	    		   index1++;
	    		   index2++;
	    	   }
	       }
	       
	    }
	
	public static void main(String[] args) {
		ReorderArray ro = new ReorderArray();
		int[] array = {2,4,6,1,3,5,7};
		ro.reOrderArray2(array);
		for (int i = 0; i < array.length; i++) {
			int j = array[i];
			System.out.print(j+" ");
		}
	}
}
