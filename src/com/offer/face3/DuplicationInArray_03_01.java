package com.offer.face3;

/**
 * ��Ŀ���ҳ��������ظ�������
 *   ��һ������Ϊn�����������е����ֶ���0~n-1�ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�
 *  ���ǲ�֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ�
 * @author admin
 *
 */
public class DuplicationInArray_03_01 {
	
	/**
	 * ˼·������ʱ�临�Ӷ�Ϊo(n),�ռ临�Ӷ�Ϊo(1)˼·
	 *   ��������������顣��ͷ��β����ɨ����������е�ÿ�����֡�
	 *  ��ɨ�赽�±�Ϊi������ʱ�����ȱȽ��������(����m����ʾ)�ǲ��ǵ���i��������ǣ����������͵�m�����ֽ��бȽϡ�
	 *  ������͵�m��������ȣ�������һ���ظ������֣����������ȣ���ѵ�iλ�����ֺ͵�mλ�����ֽ��н��������ν�����ȥ
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
			
			while(temp[i] != i) {//ѭ����ʹ��
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
		//�ظ�����������������
		 //int numbers[] = { 2, 1, 3, 1, 4 };
		//�ظ�����������С������
		 //int numbers[] = { 2, 4, 3, 1, 4 };
		//�����д��ڶ���ظ�������
		 //int numbers[] = { 4, 2, 2, 4, 1};
		//û���ظ�������
		//int numbers[] = { 2, 1, 3, 0, 4 };
		//int numbers[] = { 2, 1, 3, 5, 4 };
		int numbers[] = null;
		DuplicationInArray_03_01 du = new DuplicationInArray_03_01();
		System.out.println(du.duplicate(numbers));
	}
}
