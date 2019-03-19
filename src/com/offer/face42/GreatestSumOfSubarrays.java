package com.offer.face42;

/**
 * 连续子数组最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。
 *    数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *    要求时间复杂度为O(n)
 * 
 * @author admin
 *
 */
public class GreatestSumOfSubarrays {
	
	/**
	 * 举例分析数组规律
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
		
		if(array == null || array.length <= 0) {
			return 0;
		}
		int sum = 0;
		int result = 0;
		
		for (int i = 0; i < array.length; i++) {
			if(i == 0) {
				result = array[0];
			}
			if(sum <= 0) {
				sum = array[i];
			}else {
				sum += array[i];
			}
			if(sum > result)
				result = sum;
		}
		return result;
    }
	
	public static void main(String[] args) {
		GreatestSumOfSubarrays gsos = new GreatestSumOfSubarrays();
		System.out.println(gsos.FindGreatestSumOfSubArray(new int[] {-2,-3,-2,-7,-15,-1,-2,-2}));
	}
}
