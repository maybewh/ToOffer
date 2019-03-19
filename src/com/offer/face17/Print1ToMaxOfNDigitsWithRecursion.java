package com.offer.face17;

/**
 * ������ת��Ϊ�������еĽⷨ���ݹ��ô�������
 * ��ʵ������n����0��9��ȫ����
 * 
 * ȫ���� �õݹ�����ױ����ֵ�ÿһλ���п�����0~9�е�һλ����Ȼ��������һλ��
 * �ݹ�Ľ��������� ���� �Ѿ����������ֵ����һλ
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
     * ȥ��ǰ���0
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
