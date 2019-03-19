package com.offer.face4;

/**
 * 面试题4：二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按
 *   照从上到下的递增的顺序排列。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否有该整数
 * @author admin
 *
 */
public class FindInPartiallySortedMatrix_04 {
	
	/**
	 * 思路：以右上角的数字为基准。通过剔除某一列或某一行将范围缩小
	 *   1.如果右上角的数字等于要查找的数字，则查找结束。
	 *   2.若右上角的数字大于要查找的数字，则剔除该列
	 *   3.若右上角的数字小于要查找的数字，则剔除该行
	 *   结束时：1)找到相等的元素，返回即可
	 *    2)nums为空(没有值)时，结束
	 * @param nums
	 * @return
	 */
	boolean find(int[][] nums,int find) {
		int[][] matrix = nums;
		boolean found  =false;
		
		if(matrix != null && matrix[0].length >= 0 && matrix.length >= 0) {
			int rows = matrix.length;
			int columns = matrix[0].length;
			System.out.println("行：" + rows);
			System.out.println("列：" + columns);
			
			int row = 0;
			int column = columns - 1;
			while(row < rows && column >= 0) {
				int compare = matrix[row][column];
				if(compare == find) {
					found = true;
					break;
				}else if(compare > find) {
					//剔除一列
					column--;
				}else {
					//剔除一行
					row++;
				}
			}
		}
		return found;
		
	}
	
	public static void main(String[] args) {
		int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
		FindInPartiallySortedMatrix_04 fp = new FindInPartiallySortedMatrix_04();
		System.out.println(fp.find(matrix, 7));
	}
}
