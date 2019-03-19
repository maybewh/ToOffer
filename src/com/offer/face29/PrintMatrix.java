package com.offer.face29;

import java.util.ArrayList;

/**
 *  输入一个矩阵，从外向里按顺时针的顺序依次打印出每一个数字
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
	  * 分为四步：1.从左向右打印，第一步总是需要的
	  *  2.从上到下打印一列，判断条件，至少需要两行，即终止行数 大于 起始行数
	  *  3.从右向左打印的判断条件，圈内至少两行两列，即终止行号大于 起始行号，终止列号大于起始列号
	  *  4.从下向上打印的判断条件，至少三行两列，即 终止行号 比起始行号 至少 大 2，同时终止列号大于起始列号
	  *  
	  * @param matrix
	  * @param columns
	  * @param rows
	  * @param start
	  * @return
	  */
	private ArrayList<Integer> printMaxtrixInCircle(int[][] matrix, int columns, int rows, int start,ArrayList<Integer> list) {
		
		
		
		int endX = columns - 1 - start; //列
		int endY = rows - 1 - start;//行
		
		//从左向右打印一行
		for(int i = start; i <= endX;i++) {
			list.add(matrix[start][i]);
		}
		//从上向下打印一行
		if(start < endY) {
			for(int i = start + 1; i <= endY;i++) {
				list.add(matrix[i][endX]);
			}
		}
		//从右向左打印
		if(start < endX && start < endY) {
			for(int i = endX - 1; i >= start; i-- ) {
				list.add(matrix[endY][i]);
			}
		}
		
		//从下向上打印
		if(start < endX && start < endY - 1) {
			for(int i = endY - 1; i >= start + 1; i--) {
				list.add(matrix[i][start]);
			}
		}
		return list;
	}
}
