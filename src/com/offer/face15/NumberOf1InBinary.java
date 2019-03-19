package com.offer.face15;

/**
 * 位运算--二进制中1的个数
 * 题目:请实现一个函数，输入一个整数，输出该数中二进制表示中1的个数
 * 
 * 思路1：先把1与n做 & 运算，再将1左移1位与n做 & 运算，以此下去
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
