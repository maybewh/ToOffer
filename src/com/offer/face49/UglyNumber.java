package com.offer.face49;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author admin
 *
 */
public class UglyNumber {
	
	/**
	 * 解题思路：用一个数组保存丑数，将数组中的丑数分别与2、3、5三个丑数相乘，
	 *           当3者都大于丑数数组中最大的丑数时，将其放入到丑数数组。
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
