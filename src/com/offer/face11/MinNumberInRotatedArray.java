package com.offer.face11;

/**
 * 旋转数组的最小数字
 * 题目：输入一个递增排序的数组的一个旋转，输出旋转数组最小的元素
 * @author admin
 *
 */
public class MinNumberInRotatedArray {
	
	public int minNumberInRotateArray(int [] array) throws Exception {
		if(array == null || array.length <= 0)
			throw new Exception("不合规数组");
		
		int index1 = 0;
		int index2 = array.length - 1;
		int indexMid = index1;
		while(array[index1] >= array[index2]) {
			//结束条件
			if(index2 - index1 == 1) {
				indexMid = index2;
			    break;
			}
			
			indexMid = (index1 + index2) / 2;
			
			//如果下标为index1、index2和indexMid指向的三个数字相等，则只能顺序查找
			if(array[index1] == array[index2] && array[index1] == array[indexMid]) {
				return MidInOrder(array,index1,index2);
			}
			if(array[indexMid] >= array[index1]) {
				index1 = indexMid;
			}else if(array[indexMid] <= array[index2]){
				index2 = indexMid;
			}
			
		}	
		return array[indexMid];
        
    }

	private int MidInOrder(int[] array, int index1, int index2) {
		int result = array[index1];
		for (int i = index1 + 1; i <= index2; i++) {
			if(result > array[i]) {
				result = array[i];
			}
		}
		return result;
	}
}
