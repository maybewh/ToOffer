package com.offer.face12;

/**
 * ���ݷ�--�����е�·��
 * ��Ŀ�������һ�������������ж���һ���������Ƿ����һ�����������ַ���·����·�����ԴӾ�����
 * ����һλ�ÿ�ʼ��ÿһ�������ھ����������ҡ��ϡ����ƶ�һ�����һ��·�������˾����ĳһ����ô��·��
 * �����ٴν���ø���
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
	 * ���ݷ�--�ڵݹ�Ļ�����
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
			
			//��������
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
