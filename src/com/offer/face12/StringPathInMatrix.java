package com.offer.face12;

/**
 * 回溯法--矩阵中的路径
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含所有字符的路径。路径可以从矩阵中
 * 的任一位置开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径
 * 不能再次进入该格子
 * @author admin
 *
 */
public class StringPathInMatrix {
	
	int pathLength = 0;
	boolean[] visited = null;
	
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {	
		if(matrix == null || rows < 1 || cols < 1 || str == null) {
			return false;
		}
		
		visited = new boolean[rows * cols];	
		for (int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				
				if(hasCorePath(matrix,rows,cols,row,col,str)) {
					return true;
				}
			}
			
		}
		return false;
    
    }
	
	/**
	 * 回溯法--在递归的基础上
	 * @param matrix
	 * @param rows
	 * @param cols
	 * @param row
	 * @param col
	 * @param str
	 * @return
	 */
	private boolean hasCorePath(char[] matrix, int rows, int cols, int row, int col, char[] str) {
		    
		if(str.length == pathLength) {
			return true;
		}
		
		boolean hasPath = false;
		
		if(row >= 0 && row < rows && col >= 0 && col < cols 
				&& matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
			pathLength++;
			visited[row * cols + col] = true;
			
			//上下左右
			 hasPath = hasCorePath(matrix, rows, cols, row - 1, col, str)
							|| hasCorePath(matrix, rows, cols, row + 1, col, str)
							|| hasCorePath(matrix, rows, cols, row, col - 1, str)
							|| hasCorePath(matrix, rows, cols, row, col + 1, str);
			if(!hasPath) {
				pathLength--;
				visited[row * cols + col] = false;
			}
		}
		
		return hasPath;
	}
	
	public static void main(String[] args) {
		StringPathInMatrix sp =new StringPathInMatrix();
		char[] matrix = "ABCESFCSADEE".toCharArray();
		char[] str = "ABCCED".toCharArray();
		System.out.println(sp.hasPath(matrix, 3, 4, str));
	}
}
