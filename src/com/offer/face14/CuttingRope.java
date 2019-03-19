package com.offer.face14;

/**
 * 剪绳子
 * 题目：给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数，n>1且m>1），每段绳子的长度记为
 *   k[0],k[1],...,k[m].请问k[0] * k[1] * ... *k[m]可能的最大乘积是多少？
 *   如：当绳子的长度为8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积为18
 * @author admin
 *
 */
public class CuttingRope {
	
	/**
	 * 动态规划
	 * @param length
	 * @return
	 */
	int maxProductAfterCutting_solution1(int length) {
		if(length < 2) 
			return 0;
		if(length == 2)
			return 1;
		if(length == 3)
			return 2;
		
		int[] products = new int[length + 1];
		
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;//?? 就是 按照最长为3的段 剪的绳子
		
		int max = 0;
		for(int i = 4; i <= length;i++) {
			
			max = 0;
			for(int j = 1; j <= i/2 ; j++) {
				int product = products[j] * products[i - j];
				if(product > max) {
					max = product;
				}
			}
			products[i] = max;
		}
			
		return products[length];
	}
	
	
	/**
	 * 贪婪算法 :贪婪的思路：当length>=5时，我们尽可能的剪长度为3的绳子；
	 * 		当剩下的绳子长度为4的时候，把绳子剪成两段长度为2的绳子
	 * @param length
	 * @return
	 */
	int maxProductAfterCutting_solution2(int length) {
		
		if(length < 2)
			return 0;
		if(length == 2)
			return 1;
		if(length == 3)
			return 2;
		
		//计算出可以分成多少个三段
		int timesOf3 = length / 3;
		
		//判断最后是否存在长度为4的绳子
		if(length - timesOf3 * 3 == 1) {
			timesOf3 -= 1;
		}
		
		//计算长度为2的次数
		int timesOf2 = (length - timesOf3 * 3) / 2;
		
		return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
	}
	
	
	public static void main(String[] args) {
		CuttingRope cp = new CuttingRope();
		System.out.println("1--0--" + cp.maxProductAfterCutting_solution1(1));
		System.out.println("1--" + cp.maxProductAfterCutting_solution2(1));
		
		System.out.println("2--1--" + cp.maxProductAfterCutting_solution1(2));
		System.out.println("2--" + cp.maxProductAfterCutting_solution2(2));
		
		System.out.println("3--2--" + cp.maxProductAfterCutting_solution1(3));
		System.out.println("3--" + cp.maxProductAfterCutting_solution2(3));
		
		System.out.println("4--4--" + cp.maxProductAfterCutting_solution1(4));
		System.out.println("4--" + cp.maxProductAfterCutting_solution2(4));
		
		System.out.println("5--6--" + cp.maxProductAfterCutting_solution1(5));
		System.out.println("5--" + cp.maxProductAfterCutting_solution2(5));
		
		System.out.println("6--9--" + cp.maxProductAfterCutting_solution1(6));
		System.out.println("6--" + cp.maxProductAfterCutting_solution2(6));
		
		System.out.println("7--12--" + cp.maxProductAfterCutting_solution1(7));
		System.out.println("7--" + cp.maxProductAfterCutting_solution2(7));
		
		System.out.println("8--18--" + cp.maxProductAfterCutting_solution1(8));
		System.out.println("8--" + cp.maxProductAfterCutting_solution2(8));
	}
}
