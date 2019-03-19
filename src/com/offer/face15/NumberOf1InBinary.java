package com.offer.face15;

/**
 * λ����--��������1�ĸ���
 * ��Ŀ:��ʵ��һ������������һ����������������ж����Ʊ�ʾ��1�ĸ���
 * 
 * ˼·1���Ȱ�1��n�� & ���㣬�ٽ�1����1λ��n�� & ���㣬�Դ���ȥ
 * @author admin
 *
 */
public class NumberOf1InBinary {
   
	int numberOf1(int n) {
		
		int count = 0;
		int flag = 1;
		boolean mark = true;
		while(mark) {
			if((n & flag) == 1) {
				count++;
			}
			if(flag == 0) {
				mark = false;
			}
			
			flag = flag << 1;
		}
		return count;
	}
	
	int numberOf2(int n) {
		
		int count = 0;
		boolean mark = true;
		if(n == 0)
			return 0;
		
		while(mark) {
			++count;
			n = (n -1) & n;
			if(n == 0) {
				mark =false;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		NumberOf1InBinary nf = new NumberOf1InBinary();
		System.out.println(nf.numberOf2(0));
		
		System.out.println(nf.numberOf2(1));
		
		System.out.println(nf.numberOf2(10));
		
		System.out.println(nf.numberOf2(0x7FFFFFFF));
		
		System.out.println(nf.numberOf2(0xFFFFFFFF));
		
		System.out.println(nf.numberOf2(0x80000000));
	}
}
