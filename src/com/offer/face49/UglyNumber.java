package com.offer.face49;

/**
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * @author admin
 *
 */
public class UglyNumber {
	
	/**
	 * ����˼·����һ�����鱣��������������еĳ����ֱ���2��3��5����������ˣ�
	 *           ��3�߶����ڳ������������ĳ���ʱ��������뵽�������顣
	 * @param index
	 * @return
	 */
	public int GetUglyNumber_Solution(int index) {
		
		if(index < 1) {
			return 0;
		}
		
		int[] ugrly = new int[index];
		ugrly[0] = 1;
		
		int nextUgrlyIndex = 1;
	
		int mutiply2 = 0;
		int mutiply3 = 0;
		int mutiply5 = 0;
		
		while(nextUgrlyIndex < index) {
			
			while(ugrly[mutiply2] * 2 <= ugrly[nextUgrlyIndex - 1]) {
				mutiply2++;
			}
			while(ugrly[mutiply3] * 3 <= ugrly[nextUgrlyIndex - 1]) {
				mutiply3++;
			}
			while(ugrly[mutiply5] * 5 <= ugrly[nextUgrlyIndex - 1]) {
				mutiply5++;
			}
			
			int nextUgrlyNumber = min(ugrly[mutiply2] * 2,ugrly[mutiply3] * 3,ugrly[mutiply5] * 5);
			ugrly[nextUgrlyIndex] = nextUgrlyNumber;
			nextUgrlyIndex++;
		}
        return ugrly[index - 1];
    }

	private int min(int i, int j, int k) {
		int min = i;
		if(j < min) {
			min = j;
		}
		if(k < min) {
			min = k;
		}
		return min;
	}
	
	public static void main(String[] args) {
		UglyNumber un = new UglyNumber();
		System.out.println(un.GetUglyNumber_Solution(1500));
	}
}
