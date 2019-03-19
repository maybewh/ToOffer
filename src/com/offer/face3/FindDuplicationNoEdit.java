package com.offer.face3;

/**
 * ������3�����������޸������ҳ��ظ�������
 *  ��Ŀ����һ������Ϊn+1����������������ֶ���1��n�ķ�Χ�ڣ�������������
 *  ����һ���������ظ��ġ����ҳ�����������һ���ظ������֣��������޸������
 *  ���顣���磬������볤��Ϊ8������{2, 3, 5, 4, 3, 2, 6, 7}����ô��Ӧ��
 *  ������ظ�������2����3��
 * @author admin
 *
 */
public class FindDuplicationNoEdit {
	
	int duplication(int[] nums) throws Exception{
		
		if(nums == null || nums.length == 0) {
			throw new Exception("���鲻����Ҫ��");
		}
		
		int start = 1;
		int end = nums.length - 1;
		while(start <= end) {
			int middle = ((end - start) >> 1) + start;
			
			//ͳ��
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
