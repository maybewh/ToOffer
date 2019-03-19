package com.offer.face17;

/**
 * 将问题转化为数字排列的解法，递归让代码更简洁
 * 其实际上是n个从0到9的全排序
 * 
 * 全排列 用递归很容易表达，数字的每一位都有可能是0~9中的一位数，然后设置下一位。
 * 递归的结束条件是 我们 已经设置了数字的最后一位
 * @author admin
 *
 */
public class Print1ToMaxOfNDigitsWithRecursion {
	
	public void print1ToMaxOfNDigits(int n) {
		if(n <= 0)
			return;
		char[] number = new char[n];
		for(int i = 0;i < 10;i++) {
			number[0] = (char)(i + '0');
			printWithRecursion(number,number.length,0);
		}
	}

	private void printWithRecursion(char[] number, int length, int index) {
		if(index == length - 1) {
			print(number);
		}
		
		for(int i = 0;i < 10;i++) {
			number[index + 1] = (char)(i + '0');
			printWithRecursion(number, length, index + 1);
		}
	}
	
	 /*
     * 去掉前面的0
     */
	private void print(char[] number) {
		boolean isBeginning = true;
		int nLength = number.length;
		
		for(int i = 0 ; i < nLength;i++) {
			if(isBeginning && number[i] != '0') {
				isBeginning = false;
			}
			if(!isBeginning) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Print1ToMaxOfNDigits pn = new Print1ToMaxOfNDigits();
		pn.print1ToMaxOfNDigits(4);
	}
}
