package com.offer.face39;

import java.util.HashMap;
import java.util.Map;

/**
 * �����г��ִ�������һ�������
 * 
 * ��Ŀ: ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡����磺
 *    ����һ������Ϊ9������{1,2,3,2,2,2,5,4,2},���������г���5�Σ��������鳤�ȵ�һ��
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
