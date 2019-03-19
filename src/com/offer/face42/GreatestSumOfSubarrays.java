package com.offer.face42;

/**
 * ��������������
 * ��Ŀ������һ���������飬������������Ҳ�и�����
 *    �����е�һ������������������һ�������顣������������ĺ͵����ֵ��
 *    Ҫ��ʱ�临�Ӷ�ΪO(n)
 * 
 * @author admin
 *
 */
public class GreatestSumOfSubarrays {
	
	/**
	 * ���������������
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
