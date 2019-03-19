package com.offer.face39;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 * 
 * 题目: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如：
 *    输入一个长度为9的数组{1,2,3,2,2,2,5,4,2},由于数组中出现5次，超过数组长度的一半
 * @author admin
 *
 */
public class MoreThanHalfNumber {
	
	public int MoreThanHalfNum_Solution(int [] array) {
		
		if(array == null || array.length <= 0) {
			return 0;
		}
		int halfLength = array.length / 2;
		
		Map<Integer,Integer> count = new HashMap<>();
		
		for (int i = 0; i < array.length; i++) {
			
			if(count.get(array[i]) == null) {
				count.put(array[i], 1);
			}else {
				count.put(array[i], count.get(array[i]) + 1);
			}
			if(count.get(array[i]) > halfLength) {
				return array[i];
			}
		}
				
		return 0;
    }
	
	public static void main(String[] args) {
		MoreThanHalfNumber mth = new MoreThanHalfNumber();
		System.out.println(mth.MoreThanHalfNum_Solution(new int[] {1,2,3,2,2,2,5,4,2}));
	}
}
