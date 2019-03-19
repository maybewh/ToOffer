package com.offer.face3;

/**
 * 题目：找出数组中重复的数字
 *   在一个长度为n的数组里所有的数字都在0~n-1的范围内。数组中某些数字是重复的，
 *  但是不知道有几个数字重复了，也不知道每个数字重复了几次。
 * @author admin
 *
 */
public class DuplicationInArray_03_01 {
	
	/**
	 * 思路：采用时间复杂度为o(n),空间复杂度为o(1)思路
	 *   我们重排这个数组。从头到尾依次扫描这个数组中的每个数字。
	 *  当扫描到下标为i的数字时，首先比较这个数字(用来m来表示)是不是等于i；如果不是，则再拿它和第m个数字进行比较。
	 *  如果它和第m个数字相等，就找了一个重复的数字；如果它不相等，则把第i位的数字和第m位的数字进行交换。依次进行下去
	 * @param nums
	 * @return
	 */
	int duplicate(int[] nums) {
		if(nums == null || nums.length <= 0)
			return -1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] < 0 || nums[i] >= nums.length) {
				return -1;
			}
		}
		
		int[] temp = nums;
		for (int i = 0; i < temp.length; i++) {
			
			while(temp[i] != i) {//循环的使用
				int m = temp[i];
				if(m == temp[m]) {
					return m;
				}else {
					temp[i] = temp[m];
					temp[m] = m; 
				}
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		//重复的数字是最大的数字
		 //int numbers[] = { 2, 1, 3, 1, 4 };
		//重复的数字是最小的数字
		 //int numbers[] = { 2, 4, 3, 1, 4 };
		//数组中存在多个重复的数字
		 //int numbers[] = { 4, 2, 2, 4, 1};
		//没有重复的数字
		//int numbers[] = { 2, 1, 3, 0, 4 };
		//int numbers[] = { 2, 1, 3, 5, 4 };
		int numbers[] = null;
		DuplicationInArray_03_01 du = new DuplicationInArray_03_01();
		System.out.println(du.duplicate(numbers));
	}
}
