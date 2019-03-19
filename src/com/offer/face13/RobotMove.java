package com.offer.face13;

import javax.print.attribute.HashPrintJobAttributeSet;
import javax.sound.midi.Soundbank;

/**
 * ��Ŀ�������˵��˶���Χ
 * ������һ��m��n�еķ���һ�������˴�����(0,0)�ĸ��ӿ�ʼ�ƶ�����ÿ��
 * ���������ҡ��ϡ����ƶ�һ�񣬵����ܽ�������������������λ֮�ʹ���k�ĸ���	
 * @author admin
 *
 */
public class RobotMove {
	
	
	boolean[] visited = null;

	public int movingCount(int threshold, int rows, int cols)
    {	
		if(threshold <= 0 || rows <= 0 || cols <= 0 ) {
			return 0;
		}
		
		visited = new boolean[rows * cols];
		
	    int count = computeMaxPathLength(threshold,rows,cols,0,0);
		
		return count;    
    }
	
	private int computeMaxPathLength(int threshold, int rows, int cols, int row, int col) {
		int count = 0;
		if(check(threshold,rows,cols,row,col)) {
			
			visited[row * cols + col] = true;
			
			count = 1 + computeMaxPathLength(threshold, rows, cols, row + 1, col)
					+ computeMaxPathLength(threshold, rows, cols, row - 1, col)
					+ computeMaxPathLength(threshold, rows, cols, row, col + 1)
					+ computeMaxPathLength(threshold, rows, cols, row, col - 1);
		}
		
		return count;
	}

	private boolean check(int threshold, int rows, int cols, int row, int col) {
        if(row >= 0 && col >= 0 && col < cols && row < rows
				 && getDigit(row) + getDigit(col) <= threshold && !visited[row * cols + col]) {
        	return true;
        }
		return false;
	}

	private int getDigit(int row) {
		int temp = row;
		int sum = 0;
		while(temp != 0) {
			sum+= temp % 10;
			temp = temp / 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		RobotMove rm = new RobotMove();
		System.out.println(rm.movingCount(5,10,10));
	}
}
