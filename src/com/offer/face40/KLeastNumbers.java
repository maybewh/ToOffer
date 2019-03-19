package com.offer.face40;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * ��С��k����
 * ��Ŀ������n���������ҳ�������С��k������
 *  ���磺����4��5��1��6��2��7��3��8��8�����֣�����С��4��������1��2��3��4
 * @author admin
 *
 */
public class KLeastNumbers {
	
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		ArrayList<Integer> result = new ArrayList<>();
		if(k > input.length) {
			return result;
		}
			
		for (int i = 0; i < input.length; i++) {
			if(set.size() == k) {
				if(input[i] < set.last()) {
					set.pollLast();
					set.add(input[i]);
				}
			}else {
				set.add(input[i]);
			}
			
		}
		result = new ArrayList<>(set);
		return result; 
    }
	
	public static void main(String[] args) {
       KLeastNumbers kl = new KLeastNumbers();
       ArrayList<Integer> result = kl.GetLeastNumbers_Solution(new int[] {4,5,1,6,2,7,3,8},100);
       for (Integer integer : result) {
		System.out.print(integer +" ");
	}
	}
}
