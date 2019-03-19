package com.offer.face29;

import java.util.ArrayList;

/**
 *  ����һ�����󣬴������ﰴ˳ʱ���˳�����δ�ӡ��ÿһ������
 * @author admin
 *
 */
public class PrintMatrix {
	
	 public ArrayList<Integer> printMatrix(int [][] matrix) {
		
		 ArrayList<Integer> list = new ArrayList<>();
		 
		 if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
			 return null;
		 
		 
		 int rows = matrix.length;
		 int columns = matrix[0].length;
		 int start = 0;
		 
		 while(columns > start * 2 && rows > start * 2) {
			 
			list = printMaxtrixInCircle(matrix,columns,rows,start,list);
			++start;
		 }
		 return list;     
	 }
	 
	 /**
	  * ��Ϊ�Ĳ���1.�������Ҵ�ӡ����һ��������Ҫ��
	  *  2.���ϵ��´�ӡһ�У��ж�������������Ҫ���У�����ֹ���� ���� ��ʼ����
	  *  3.���������ӡ���ж�������Ȧ�������������У�����ֹ�кŴ��� ��ʼ�кţ���ֹ�кŴ�����ʼ�к�
	  *  4.�������ϴ�ӡ���ж������������������У��� ��ֹ�к� ����ʼ�к� ���� �� 2��ͬʱ��ֹ�кŴ�����ʼ�к�
	  *  
	  * @param matrix
	  * @param columns
	  * @param rows
	  * @param start
	  * @return
	  */
	private ArrayList<Integer> printMaxtrixInCircle(int[][] matrix, int columns, int rows, int start,ArrayList<Integer> list) {
		
		
		
		int endX = columns - 1 - start; //��
		int endY = rows - 1 - start;//��
		
		//�������Ҵ�ӡһ��
		for(int i = start; i <= endX;i++) {
			list.add(matrix[start][i]);
		}
		//�������´�ӡһ��
		if(start < endY) {
			for(int i = start + 1; i <= endY;i++) {
				list.add(matrix[i][endX]);
			}
		}
		//���������ӡ
		if(start < endX && start < endY) {
			for(int i = endX - 1; i >= start; i-- ) {
				list.add(matrix[endY][i]);
			}
		}
		
		//�������ϴ�ӡ
		if(start < endX && start < endY - 1) {
			for(int i = endY - 1; i >= start + 1; i--) {
				list.add(matrix[i][start]);
			}
		}
		return list;
	}
}
