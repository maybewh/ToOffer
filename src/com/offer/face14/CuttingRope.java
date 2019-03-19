package com.offer.face14;

/**
 * ������
 * ��Ŀ������һ������Ϊn�����ӣ�������Ӽ���m�Σ�m��n����������n>1��m>1����ÿ�����ӵĳ��ȼ�Ϊ
 *   k[0],k[1],...,k[m].����k[0] * k[1] * ... *k[m]���ܵ����˻��Ƕ��٣�
 *   �磺�����ӵĳ���Ϊ8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻�Ϊ18
 * @author admin
 *
 */
public class CuttingRope {
	
	/**
	 * ��̬�滮
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
		products[3] = 3;//?? ���� �����Ϊ3�Ķ� ��������
		
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
	 * ̰���㷨 :̰����˼·����length>=5ʱ�����Ǿ����ܵļ�����Ϊ3�����ӣ�
	 * 		��ʣ�µ����ӳ���Ϊ4��ʱ�򣬰����Ӽ������γ���Ϊ2������
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
		
		//��������Էֳɶ��ٸ�����
		int timesOf3 = length / 3;
		
		//�ж�����Ƿ���ڳ���Ϊ4������
		if(length - timesOf3 * 3 == 1) {
			timesOf3 -= 1;
		}
		
		//���㳤��Ϊ2�Ĵ���
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
