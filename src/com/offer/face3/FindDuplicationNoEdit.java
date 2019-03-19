package com.offer.face3;

/**
 * 面试题3（二）：不修改数组找出重复的数字
 *  题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
 *  少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 *  数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 *  输出是重复的数字2或者3。
 * @author admin
 *
 */
public class FindDuplicationNoEdit {
	
	int duplication(int[] nums) throws Exception{
		
		if(nums == null || nums.length == 0) {
			throw new Exception("数组不符合要求");
		}
		
		int start = 1;
		int end = nums.length - 1;
		while(start <= end) {
			int middle = ((end - start) >> 1) + start;
			
			//统计
			int count = countRange(nums,start,middle);
			
			if(start == end) {
				if(count > 1)
				  return start;
				else
					break;
			}
			
			if(count > (middle - start + 1)) {
				end = middle;
			}else {
				start = middle + 1;
			}
		}
		return -1;
	}

	private int countRange(int[] nums, int start, int middle) {
		int count = 0;
		
		if(nums == null || nums.length == 0)
			return 0;
		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			if(j>= start && j <= middle){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		//int numbers[] = { 2, 3, 5, 4, 3, 2, 6, 7 };
		int numbers[] = { 1, 2, 3, 4, 5, 6, 7, 1, 8 };
		FindDuplicationNoEdit df = new FindDuplicationNoEdit();
		System.out.println(df.duplication(numbers));
	}
}
